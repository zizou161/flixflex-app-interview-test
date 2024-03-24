package com.factorydigital.flixflex.userProfile;

import com.factorydigital.flixflex.movie.Movie;
import com.factorydigital.flixflex.user.UserDetails;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user_profile")
public class UserPofile {

    @Id
    @GeneratedValue
    private Long id;

    private String profileName;

    @OneToOne
    private UserDetails userDetails;

    @ManyToMany
    @JoinTable(
            name = "profile_favorite_movies",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    List<Movie> favoriteMovies;


    public UserPofile(String profileName) {
        this.profileName = profileName;
    }

    public UserPofile() {
    }
}
