package com.factorydigital.flixflex.userProfile;

import com.factorydigital.flixflex.movie.MovieDto;
import com.factorydigital.flixflex.movie.MovieMapper;
import com.factorydigital.flixflex.tvShow.TvShowDto;
import com.factorydigital.flixflex.tvShow.TvShowMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/v1/user-profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final UserProfileMapper userProfileMapper;
    private final MovieMapper movieMapper;
    private final TvShowMapper tvShowMapper;

    @GetMapping(path = "/add-movie-to-favorites")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "add a movie to favorite list")
    public ResponseEntity<UserProfileDto> addMovieToFavorites(@RequestParam Long movieId) throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(userProfileMapper.toDto(userProfileService.addMovieToFavorites(movieId)));
    }

    @GetMapping(path = "/add-tvShow-to-favorites")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "add a tvShow to favorite list")
    public ResponseEntity<UserProfileDto> addTvShowToFavorites(@RequestParam Long tvShowId) throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(userProfileMapper.toDto(userProfileService.addTvShowToFavorites(tvShowId)));
    }

    @GetMapping(path = "/show-movies-favorites")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "show movies favorite list")
    public ResponseEntity<List<MovieDto>> getMovieFavorites() throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(userProfileService.getMovieFavorites().stream().map(movieMapper::toDto).toList());
    }

    @GetMapping(path = "/show-tvShow-favorites")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "show tv shows favorite list")
    public ResponseEntity<List<TvShowDto>> getTvShowFavorites() throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(userProfileService.getTvShowFavorites().stream().map(tvShowMapper::toDto).toList());
    }

    @DeleteMapping(path = "/favorites/movie")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "remove a movie from favorites")
    public ResponseEntity<UserProfileDto> removeMovieFromFavorites(@RequestParam Long movieId) {
        try {
            return ResponseEntity.ok(userProfileMapper.toDto(userProfileService.removeMovieFromFavorites(movieId)));
        } catch (UserPrincipalNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = "/favorites/tvShow")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "remove a tv show from favorites")
    public ResponseEntity<UserProfileDto> removeTvShowFromFavorites(@RequestParam Long tvShowId) {
        try {
            return ResponseEntity.ok(userProfileMapper.toDto(userProfileService.removeTvShowFromFavorites(tvShowId)));
        } catch (UserPrincipalNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
