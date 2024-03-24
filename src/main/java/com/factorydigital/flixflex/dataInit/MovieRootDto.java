package com.factorydigital.flixflex.dataInit;

import com.factorydigital.flixflex.movie.MovieDto;
import lombok.Data;

import java.util.ArrayList;

@Data
public class MovieRootDto {
    private int page;
    private ArrayList<MovieDto> results;
    private int total_pages;
    private int total_results;
}
