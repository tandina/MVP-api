package com.mvp.P6mvpapi.repository;
import com.mvp.P6mvpapi.models.Role;
import com.mvp.P6mvpapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByRole(Role role);

    Optional<User> findByUsername(String username);
}