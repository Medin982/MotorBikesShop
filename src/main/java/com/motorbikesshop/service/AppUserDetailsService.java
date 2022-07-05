package com.motorbikesshop.service;

import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findByEmail(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email" + username + "not found!"));
    }

    private UserDetails map(UserEntity user) {
        return User.builder().
                username(user.getEmail()).
                password(user.getPassword()).
                build();
    }
}
