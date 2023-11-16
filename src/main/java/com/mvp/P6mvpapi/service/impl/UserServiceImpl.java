package com.mvp.P6mvpapi.service.impl;

import com.mvp.P6mvpapi.models.User;
import com.mvp.P6mvpapi.repository.UserRepository;
import com.mvp.P6mvpapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("utilisateur introuvable"));
            }
        };
    }
    @Override
    public User findById(int id) {
        return userRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable"));
    }
}
