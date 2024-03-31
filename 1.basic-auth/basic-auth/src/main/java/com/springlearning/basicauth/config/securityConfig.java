package com.springlearning.basicauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {

    // reference - https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html

    // used to add user for authentication
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails admin = User.withUsername("subhash")
                .password(passwordEncoder.encode("sam"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("suman")
                .password("sam")
                .roles("USER")
                .build();

        // not working
//        // The simplest way to indicate a user is authenticated is to set the SecurityContextHolder directly:
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//        // Spring Security does not care what type of Authentication implementation is set on the SecurityContext.
//        // Here, we use TestingAuthenticationToken, because it is very simple.
//        Authentication authentication =
//                new TestingAuthenticationToken("subham", "subh", "ROLE_USER");
//        context.setAuthentication(authentication);
//
//        SecurityContextHolder.setContext(context);

        return new InMemoryUserDetailsManager(admin, user);
    }

    // used for authorization
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()) // will allow to pass credential in header i.e. postman
                .formLogin(Customizer.withDefaults()); // will send login page for credential

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
