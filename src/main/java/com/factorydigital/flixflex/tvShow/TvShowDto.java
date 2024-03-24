package com.factorydigital.flixflex.tvShow;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TvShowDto {

    private Boolean adult;
    private String backdrop_path;
    private ArrayList<Integer> genre_ids;
    private int id;
    private ArrayList<String> origin_country;
    private String original_language;
    private String original_name;
    private String overview;
    private double popularity;
    private String poster_path;
    private String first_air_date;
    private String name;
    private double vote_average;
    private int vote_count;

}
