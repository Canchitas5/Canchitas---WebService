package com.example.Canchitas.Services.Impl;

import com.example.Canchitas.Entities.User;
import com.example.Canchitas.Repositores.UserRepository;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImplLogin implements UserDetailsService {
    private final UserRepository iUserRepository;
    private PasswordEncoder passwordEncoder; // BCryptPasswordEncoder

    public UserServiceImplLogin(UserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = iUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not found with email: " + email));


        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
    @SneakyThrows
    public Optional<User> authenticateUser(String email, String rawPassword) {
        Optional<User> user = iUserRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(rawPassword, user.get().getPassword())) {
            return user;
        }
        return null;
    }
}
