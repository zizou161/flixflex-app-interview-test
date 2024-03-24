package com.factorydigital.flixflex.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Iterable<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Iterable<Movie> getTop5ByPopularity() {
        return movieRepository.findTop5ByOrderByPopularityDesc();
    }

    public Page<Movie> getMoviesPaged(int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, 10);
        return movieRepository.findAll(pageRequest);
    }

    public Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public Iterable<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findMoviesByTitleContainingIgnoreCase(title);
    }

    public String getMovieTrailerUrl(Long movieId) {
        return getMovie(movieId).getTrailerUrl();
    }
}
