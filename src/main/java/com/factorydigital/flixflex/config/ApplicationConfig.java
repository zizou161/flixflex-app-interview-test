package com.factorydigital.flixflex.config;

import com.factorydigital.flixflex.user.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private UserDetailsRepository userDetailsRepository;
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userDetailsRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
