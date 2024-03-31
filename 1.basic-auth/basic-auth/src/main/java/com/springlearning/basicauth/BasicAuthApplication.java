package com.springlearning.basicauth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class BasicAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Bean
	public CommandLineRunner runnner(){
		// not working
		return args -> {
			// The simplest way to indicate a user is authenticated is to set the SecurityContextHolder directly:
			SecurityContext context = SecurityContextHolder.createEmptyContext();
			// Spring Security does not care what type of Authentication implementation is set on the SecurityContext.
			// Here, we use TestingAuthenticationToken, because it is very simple.
			Authentication authentication =
					new TestingAuthenticationToken("subham", "subh", "ROLE_USER");
			context.setAuthentication(authentication);

			SecurityContextHolder.setContext(context);
		};
	}

}
