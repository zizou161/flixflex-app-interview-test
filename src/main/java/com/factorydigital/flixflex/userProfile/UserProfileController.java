package com.factorydigital.flixflex.userProfile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user-profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping(path = "/add-favorites")
    @SecurityRequirement(name = "Bearer Authorization")
    @Operation(summary = "add a movie to favorite list")
    public ResponseEntity<UserPofile> addMovieToFavorites(@RequestParam Long movieId) {
        return ResponseEntity.ok(userProfileService.addMovieToFavorites(movieId));
    }
}
