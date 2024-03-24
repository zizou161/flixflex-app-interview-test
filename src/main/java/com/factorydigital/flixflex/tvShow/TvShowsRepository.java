package com.factorydigital.flixflex.tvShow;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TvShowsRepository extends PagingAndSortingRepository<TvShow, Long>, CrudRepository<TvShow, Long> {

    public Iterable<TvShow> findTop5ByOrderByPopularityDesc();
}
