package com.factorydigital.flixflex.movie;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class MovieDto implements Serializable {

    private boolean adult;
    private String backdrop_path;
    private ArrayList<Integer> genre_ids;
    private Long id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
}
