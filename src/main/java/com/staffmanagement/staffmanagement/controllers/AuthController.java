package com.staffmanagement.staffmanagement.controllers;

import com.staffmanagement.staffmanagement.models.LoginRequest;
import com.staffmanagement.staffmanagement.services.TokenService;

import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/token")
public class AuthController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;



    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("")
    public String welcome(){

        return "Welcome to Token section";
    }

    @PostMapping("")
    public String getToken(@RequestBody LoginRequest loginRequest){
        System.out.println("test");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        return tokenService.generateToken(authentication);
    }
}
