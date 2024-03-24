package com.factorydigital.flixflex.tvShow;


import com.factorydigital.flixflex.shared.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class TvShowMapper implements ObjectMapper<TvShow, TvShowDto> {


    @Override
    public TvShow toEntity(TvShowDto dto) {
        TvShow entity = new TvShow();
        entity.setName(dto.getName());
        entity.setAdult(dto.getAdult());
        entity.setBackdrop_path(dto.getBackdrop_path());
        entity.setOriginal_name(dto.getOriginal_name());
        entity.setOverview(dto.getOverview());
        entity.setPopularity(dto.getPopularity());
        entity.setPoster_path(dto.getPoster_path());
        entity.setVote_average(dto.getVote_average());
        entity.setVote_count(dto.getVote_count());
        entity.setOriginal_language(entity.getOriginal_language());
        return entity;
    }

    @Override
    public TvShowDto toDto(TvShow entity) {
        TvShowDto dto = new TvShowDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAdult(entity.getAdult());
        dto.setBackdrop_path(entity.getBackdrop_path());
        dto.setOriginal_name(entity.getOriginal_name());
        dto.setOverview(entity.getOverview());
        dto.setPopularity(entity.getPopularity());
        dto.setPoster_path(entity.getPoster_path());
        dto.setVote_average(entity.getVote_average());
        dto.setVote_count(entity.getVote_count());
        dto.setOriginal_language(entity.getOriginal_language());
        return dto;
    }
}
