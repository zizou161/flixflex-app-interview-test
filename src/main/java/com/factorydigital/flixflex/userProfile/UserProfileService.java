package com.factorydigital.flixflex.userProfile;

import com.factorydigital.flixflex.movie.Movie;
import com.factorydigital.flixflex.movie.MovieRepository;
import com.factorydigital.flixflex.user.UserDetails;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final MovieRepository movieRepository;

    public UserPofile addMovieToFavorites(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            UserDetails user = (UserDetails) auth.getPrincipal();
            UserPofile userPofile = user.getUserPofile();
            userPofile.getFavoriteMovies().add(movie);
            return userProfileRepository.save(userPofile);
        }
        return null;
    }
}
