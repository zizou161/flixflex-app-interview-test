package com.factorydigital.flixflex.tvShow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TvShowService {

    private final TvShowsRepository tvShowsRepository;

    public Iterable<TvShow> getAll() {
        return tvShowsRepository.findAll();
    }

    public Iterable<TvShow> getTop5ByPopularity() {
        return tvShowsRepository.findTop5ByOrderByPopularityDesc();
    }
}
