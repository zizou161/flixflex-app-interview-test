package com.factorydigital.flixflex.tvShow;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tv-shows")
@RequiredArgsConstructor
public class TvShowController {

    private final TvShowService tvShowService;
    @GetMapping
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "returns list of series")
    public ResponseEntity<Iterable<TvShow>> getAll() {
        return ResponseEntity.ok(tvShowService.getAll());
    }
}
