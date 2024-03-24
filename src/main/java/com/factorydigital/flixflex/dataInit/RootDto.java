package com.factorydigital.flixflex.dataInit;

import java.util.ArrayList;

public class RootDto {
    public int page;
    public ArrayList<MoviesSeriesInitDto> results;
    public int total_pages;
    public int total_results;

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
