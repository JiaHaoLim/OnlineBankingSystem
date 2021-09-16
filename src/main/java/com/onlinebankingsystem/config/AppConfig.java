package com.onlinebankingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
	public static final String USER_JPA = "UserJpaRepository";
	public static final String ACCOUNT_HOLDER_JPA = "AccountHolderJpaRepository";
	public static final String ACCOUNT_JPA = "AccountJpaRepository";
	public static final String TRANSACTION_JPA = "TransactionJpaRepository";
	public static final String SERVICE_REQUEST_JPA = "ServiceRequestJpaRepository";
	
	public static final String USER_DAO = USER_JPA;
	public static final String ACCOUNT_HOLDER_DAO = ACCOUNT_HOLDER_JPA;
	public static final String ACCOUNT_DAO = ACCOUNT_JPA;
	public static final String TRANSACTION_DAO = TRANSACTION_JPA;
	public static final String SERVICE_REQUEST_DAO = SERVICE_REQUEST_JPA;
	
	public static final int MAX_FAILED_ATTEMPTS = 3; 
	
    @Bean
    public ResourceBundleMessageSource messageSource() {

    	ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("messages");
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
}