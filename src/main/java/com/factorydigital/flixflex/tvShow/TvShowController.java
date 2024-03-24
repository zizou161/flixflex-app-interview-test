package com.factorydigital.flixflex.tvShow;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "returns list of series paged")
    public ResponseEntity<Page<TvShow>> getTvShowsPaged(@RequestParam int pageNum) {
        return ResponseEntity.ok(tvShowService.getTvShowsPaged(pageNum));
    }

    @GetMapping("/{tvShowId}")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "returns details of a series")
    public ResponseEntity<TvShow> getAll(@PathVariable(name = "tvShowId") Long tvShowId) {
        return ResponseEntity.ok(tvShowService.getTvShow(tvShowId));
    }

    @GetMapping("/search")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "search for series by name containing")
    public ResponseEntity<Iterable<TvShow>> searchTvShowByName(@RequestParam String name) {
        return ResponseEntity.ok(tvShowService.searchTvShowByName(name));
    }
}
