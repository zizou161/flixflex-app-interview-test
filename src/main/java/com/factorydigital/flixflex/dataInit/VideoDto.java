package com.factorydigital.flixflex.dataInit;

import lombok.Data;

import java.util.Date;

@Data
public class VideoDto {
    public String iso_639_1;
    public String iso_3166_1;
    public String name;
    public String key;
    public String site;
    public int size;
    public String type;
    public boolean official;
    public Date published_at;
    public String id;
}
