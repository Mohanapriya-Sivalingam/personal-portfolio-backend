package com.example.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        HttpSecurity httpSecurity = http
                .csrf(AbstractHttpConfigurer::disable) // disable csrf
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/contactms/sendmessage").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

}
