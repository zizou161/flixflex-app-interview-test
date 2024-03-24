package com.factorydigital.flixflex.movie;


import com.factorydigital.flixflex.shared.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements ObjectMapper<Movie, MovieDto> {


    @Override
    public Movie toEntity(MovieDto dto) {
        Movie entity = new Movie();
        entity.setAdult(dto.isAdult());
        entity.setOverview(dto.getOverview());
        entity.setPopularity(dto.getPopularity());
        entity.setTitle(dto.getTitle());
        entity.setOriginal_language(dto.getOriginal_language());
        entity.setOriginal_title(dto.getOriginal_title());
        entity.setVote_average(dto.getVote_average());
        entity.setVote_count(dto.getVote_count());
        return entity;
    }

    @Override
    public MovieDto toDto(Movie entity) {
        MovieDto dto = new MovieDto();
        dto.setId(entity.getId());
        dto.setAdult(entity.isAdult());
        dto.setOverview(entity.getOverview());
        dto.setPopularity(entity.getPopularity());
        dto.setTitle(entity.getTitle());
        dto.setOriginal_language(entity.getOriginal_language());
        dto.setOriginal_title(entity.getOriginal_title());
        dto.setVote_average(entity.getVote_average());
        dto.setVote_count(entity.getVote_count());
        return dto;
    }
}
