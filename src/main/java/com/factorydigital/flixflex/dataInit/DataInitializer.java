package com.factorydigital.flixflex.dataInit;

import com.factorydigital.flixflex.movie.Movie;
import com.factorydigital.flixflex.movie.MovieDto;
import com.factorydigital.flixflex.movie.MovieMapper;
import com.factorydigital.flixflex.movie.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final String IMDB_API_URL = "https://api.themoviedb.org/3/discover/%s?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public void run(String... args) throws Exception {
        if (movieRepository.count() == 0) {
            List<Movie> movies = fetchMovies().stream().map(movieMapper::toEntity).toList();
            movieRepository.saveAll(movies);
        }

    }

    public ArrayList<MovieDto> fetchMovies() {
        String moviesApiUrl = String.format(IMDB_API_URL, "movie");
        RootDto data = restTemplate.getForObject(moviesApiUrl, RootDto.class);
        assert data != null;
        return data.getResults();
    }
}
