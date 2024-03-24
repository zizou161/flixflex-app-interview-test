package com.factorydigital.flixflex.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {

    @GetMapping
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "this is a demo API")
    public ResponseEntity<String> greetings() {
        return ResponseEntity.ok("hello from secured endpoint");
    }
}
