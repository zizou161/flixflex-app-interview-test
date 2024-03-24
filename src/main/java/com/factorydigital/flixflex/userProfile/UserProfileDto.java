package com.factorydigital.flixflex.userProfile;

import com.factorydigital.flixflex.movie.MovieDto;
import com.factorydigital.flixflex.tvShow.TvShowDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UserProfileDto implements Serializable {
    private String profileName;
    private List<MovieDto> favoriteMovies;
    private List<TvShowDto> favoriteTvShows;
}
