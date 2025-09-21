package com.example.flowtrack.highwayroad.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component
@ConfigurationProperties(prefix = "ex")
public class ExProps {
    private String baseUrl;
    private String apiKey;
}

