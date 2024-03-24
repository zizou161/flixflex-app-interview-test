package com.factorydigital.flixflex.userProfile;

import com.factorydigital.flixflex.movie.Movie;
import com.factorydigital.flixflex.tvShow.TvShow;
import com.factorydigital.flixflex.user.UserDetails;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue
    private Long id;

    private String profileName;

    @OneToOne
    private UserDetails userDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "profile_favorite_movies",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    List<Movie> favoriteMovies;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "profile_favorite_tv_shows",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "tv_show_id")
    )
    List<TvShow> favoriteTvShows;


    public UserProfile(String profileName) {
        this.profileName = profileName;
    }

    public UserProfile() {
    }
}
