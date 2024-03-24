package com.factorydigital.flixflex.movie;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "returns list of movies")
    public ResponseEntity<Iterable<Movie>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping(path = "/top5")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "returns list of top 5 movies ordered by popularity")
    public ResponseEntity<Iterable<Movie>> getTop5ByPopularity() {
        return ResponseEntity.ok(movieService.getTop5ByPopularity());
    }

    @GetMapping(path = "/paged")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "returns list of movies in batches of 10")
    public ResponseEntity<Page<Movie>> getMoviesPaged(@RequestParam int pageNum) {
        return ResponseEntity.ok(movieService.getMoviesPaged(pageNum));
    }

    @GetMapping("/{movieId}")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "get details of a movie")
    public ResponseEntity<Movie> getOne(@PathVariable(name = "movieId") Long movieId) {
        return ResponseEntity.ok(movieService.getMovie(movieId));
    }
}
