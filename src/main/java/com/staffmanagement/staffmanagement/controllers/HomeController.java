package com.staffmanagement.staffmanagement.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staffmanagement.staffmanagement.config.ContentProperties;

import java.util.Collection;

@RestController
public class HomeController {

    private final ContentProperties properties;

    public HomeController(ContentProperties properties){
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentProperties home(){
        return properties;
    }

    @GetMapping("/user")
    public String getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> username = authentication.getAuthorities();
        return "Logged-in user: " + username;
    }
    
}
