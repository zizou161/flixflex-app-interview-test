package com.factorydigital.flixflex.dataInit;

import com.factorydigital.flixflex.tvShow.TvShowDto;
import lombok.Data;

import java.util.ArrayList;

@Data
public class TvShowRootDto {
    private int page;
    private ArrayList<TvShowDto> results;
    private int total_pages;
    private int total_results;
}
