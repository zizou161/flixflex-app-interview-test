package com.factorydigital.flixflex.auth;

import com.factorydigital.flixflex.config.JwtService;
import com.factorydigital.flixflex.user.Role;
import com.factorydigital.flixflex.user.UserDetails;
import com.factorydigital.flixflex.user.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserDetailsRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationReponse register(RegisterRequest request) {
        var user = UserDetails.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationReponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationReponse authenticate(AuthenticationRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationReponse.builder()
                .token(jwtToken)
                .build();
    }
}
