package com.mvp.P6mvpapi.service;


import com.mvp.P6mvpapi.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    User findById(int id);
}
