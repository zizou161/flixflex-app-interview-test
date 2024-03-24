package com.factorydigital.flixflex.userProfile;

import com.factorydigital.flixflex.movie.MovieMapper;
import com.factorydigital.flixflex.shared.ObjectMapper;
import com.factorydigital.flixflex.tvShow.TvShowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileMapper implements ObjectMapper<UserProfile, UserProfileDto> {

    private final MovieMapper movieMapper;
    private final TvShowMapper tvShowMapper;

    @Override
    public UserProfile toEntity(UserProfileDto dto) {
        UserProfile entity = new UserProfile();
        entity.setProfileName(dto.getProfileName());
        entity.setFavoriteMovies(dto.getFavoriteMovies().stream().map(movieMapper::toEntity).toList());
        entity.setFavoriteTvShows(dto.getFavoriteTvShows().stream().map(tvShowMapper::toEntity).toList());
        return entity;
    }

    @Override
    public UserProfileDto toDto(UserProfile entity) {
        UserProfileDto dto = new UserProfileDto();
        dto.setProfileName(entity.getProfileName());
        dto.setFavoriteMovies(entity.getFavoriteMovies().stream().map(movieMapper::toDto).toList());
        dto.setFavoriteTvShows(entity.getFavoriteTvShows().stream().map(tvShowMapper::toDto).toList());
        return dto;
    }
}
