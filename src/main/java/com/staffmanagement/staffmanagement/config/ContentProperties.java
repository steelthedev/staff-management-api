package com.staffmanagement.staffmanagement.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record ContentProperties (
    String welcomeMessage, String about, String version
) {
    
}
