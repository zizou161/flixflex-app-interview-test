package com.factorydigital.flixflex.dataInit;

import com.factorydigital.flixflex.movie.MovieDto;
import lombok.Data;

import java.util.ArrayList;
@Data
public class RootDto {
    private int page;
    private ArrayList<MovieDto> results;
    private int total_pages;
    private int total_results;

    @Override
    public String toString() {
        return "RootDto{" +
                "page=" + page +
                ", results=" + results +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
