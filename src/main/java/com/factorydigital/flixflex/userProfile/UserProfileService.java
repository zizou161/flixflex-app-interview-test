package com.factorydigital.flixflex.userProfile;

import com.factorydigital.flixflex.movie.Movie;
import com.factorydigital.flixflex.movie.MovieRepository;
import com.factorydigital.flixflex.tvShow.TvShow;
import com.factorydigital.flixflex.tvShow.TvShowsRepository;
import com.factorydigital.flixflex.user.UserDetails;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final MovieRepository movieRepository;
    private final TvShowsRepository tvShowsRepository;


    public UserProfile addMovieToFavorites(Long movieId) throws UserPrincipalNotFoundException {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));
        UserProfile userProfile = getCurrentUserProfile().orElseThrow(() -> new UserPrincipalNotFoundException("user not found"));
        userProfile.getFavoriteMovies().add(movie);
        return userProfileRepository.save(userProfile);
    }

    public Optional<UserProfile> getCurrentUserProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return Optional.empty();
        } else {
            UserDetails user = (UserDetails) auth.getPrincipal();
            UserProfile userProfile = user.getUserProfile();
            return Optional.of(userProfile);
        }
    }

    public UserProfile addTvShowToFavorites(Long tvShowId) throws UserPrincipalNotFoundException {
        TvShow tvShow = tvShowsRepository.findById(tvShowId).orElseThrow(() -> new EntityNotFoundException("tvShow not found"));
        UserProfile userProfile = getCurrentUserProfile().orElseThrow(() -> new UserPrincipalNotFoundException("user not found"));
        userProfile.getFavoriteTvShows().add(tvShow);
        return userProfileRepository.save(userProfile);
    }
}
