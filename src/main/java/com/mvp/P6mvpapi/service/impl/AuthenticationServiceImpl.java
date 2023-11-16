package com.mvp.P6mvpapi.service.impl;

import com.mvp.P6mvpapi.dto.JwtAuthenticationResponse;
import com.mvp.P6mvpapi.dto.SignUpRequest;
import com.mvp.P6mvpapi.dto.SigninRequest;
import com.mvp.P6mvpapi.models.Role;
import com.mvp.P6mvpapi.models.User;
import com.mvp.P6mvpapi.repository.UserRepository;
import com.mvp.P6mvpapi.service.AuthenticationService;
import com.mvp.P6mvpapi.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public User signup (SignUpRequest signupRequest){
        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setUsername(signupRequest.getUsername());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        return userRepository.save(user);
    }
    public JwtAuthenticationResponse signin(SigninRequest signinRequest){
        User user;
        if (signinRequest.getUsernameOrEmail().contains("@")) {
            user = userRepository.findByEmail(signinRequest.getUsernameOrEmail()).orElseThrow(()-> new IllegalArgumentException("email invalide"));
        } else {
            user = userRepository.findByUsername(signinRequest.getUsernameOrEmail()).orElseThrow(()-> new IllegalArgumentException("nom d'utilisateur invalide"));
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), signinRequest.getPassword()));

        var jwt = jwtService.generateToken(user);
        JwtAuthenticationResponse jwtAuthenticationResponse= new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);

        return jwtAuthenticationResponse;
        }
}