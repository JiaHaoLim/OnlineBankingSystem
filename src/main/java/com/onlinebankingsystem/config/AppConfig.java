package com.onlinebankingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
	
	public static final int MAX_FAILED_ATTEMPTS = 3; 

    @Bean
    public ResourceBundleMessageSource messageSource() {

    	ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("messages");
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
}