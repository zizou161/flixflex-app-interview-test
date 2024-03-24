package com.factorydigital.flixflex.movie;

import lombok.RequiredArgsConstructor;
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
}
