package com.factorydigital.flixflex.movie;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String original_language;
    private String original_title;
    @Column(columnDefinition = "TEXT")
    private String overview;
    private double popularity;
    private String title;
    private double vote_average;
    private int vote_count;
    private boolean adult;
}
