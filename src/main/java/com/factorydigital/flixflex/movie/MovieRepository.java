package com.factorydigital.flixflex.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long>, CrudRepository<Movie, Long> {

    public Iterable<Movie> findTop5ByOrderByPopularityDesc();

    public Page<Movie> findAllBy(Pageable pageable);

}
