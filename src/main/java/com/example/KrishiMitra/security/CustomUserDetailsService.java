package com.example.KrishiMitra.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.
SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.
UserDetails;

import org.springframework.security.core.userdetails.
UserDetailsService;

import org.springframework.security.core.userdetails.
UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.KrishiMitra.entity.User;
import com.example.KrishiMitra.repository.UserRepository;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(
            String email)
            throws UsernameNotFoundException {

        User user = repo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User Not Found"));

        return new org.springframework.security.core.userdetails.User(

                user.getEmail(),
                user.getPassword(),

                List.of(
                        new SimpleGrantedAuthority(
                                "ROLE_"
                                + user.getRole()
                                        .name()
                        )
                )
        );
    }
}