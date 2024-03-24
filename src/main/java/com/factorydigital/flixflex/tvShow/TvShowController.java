package com.factorydigital.flixflex.tvShow;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(path = "/top5")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "returns list of top 5 series ordered by popularity")
    public ResponseEntity<Iterable<TvShow>> getTop5ByPopularity() {
        return ResponseEntity.ok(tvShowService.getTop5ByPopularity());
    }

    @GetMapping(path = "/paged")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "returns list of tv shows paged")
    public ResponseEntity<Page<TvShow>> getTvShowsPaged(@RequestParam int pageNum) {
        return ResponseEntity.ok(tvShowService.getTvShowsPaged(pageNum));
    }
}
