package com.staffmanagement.staffmanagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staffmanagement.staffmanagement.config.ContentProperties;

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
    
}
