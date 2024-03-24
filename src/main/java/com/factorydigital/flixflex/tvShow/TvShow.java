package com.factorydigital.flixflex.tvShow;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tv_show")
public class TvShow implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String backdrop_path;
    private String original_language;
    private String original_name;
    @Column(columnDefinition = "TEXT")
    private String overview;
    private double popularity;
    private String poster_path;
    private String name;
    private double vote_average;
    private int vote_count;
    private Boolean adult;
}
