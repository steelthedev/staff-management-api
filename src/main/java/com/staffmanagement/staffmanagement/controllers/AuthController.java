package com.staffmanagement.staffmanagement.controllers;

import com.staffmanagement.staffmanagement.services.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class AuthController {

    private final TokenService tokenService;
    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("")
    public String welcome(){
        return "Welcome to Token section";
    }

    @PostMapping("/login")
    public String getToken(Authentication authentication){
        return tokenService.generateToken(authentication);
    }
}
