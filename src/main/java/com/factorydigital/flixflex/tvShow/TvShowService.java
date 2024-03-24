package com.factorydigital.flixflex.tvShow;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<TvShow> getTvShowsPaged(int pageNum) {
        PageRequest pageRequest = PageRequest.of(pageNum, 10);
        return tvShowsRepository.findAll(pageRequest);
    }

    public TvShow getTvShow(Long tvShowId) {
        return tvShowsRepository.findById(tvShowId).orElse(null);
    }

    public Iterable<TvShow> searchTvShowByName(String name) {
        return tvShowsRepository.findTvShowsByNameContainingIgnoreCase(name);
    }
}
