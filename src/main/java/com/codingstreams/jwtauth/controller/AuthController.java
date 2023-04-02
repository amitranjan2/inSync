package com.codingstreams.jwtauth.controller;

import com.codingstreams.jwtauth.dto.AuthRequest;
import com.codingstreams.jwtauth.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app-auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest){
        // Get user details
        UserDetails user = userDetailsService.loadUserByUsername(authRequest.getUsername());

        // Generate token
        String token = jwtProvider.generateToken(user.getUsername());

        return token;
    }
}