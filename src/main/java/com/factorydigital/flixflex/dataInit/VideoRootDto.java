package com.factorydigital.flixflex.dataInit;

import lombok.Data;

import java.util.ArrayList;

@Data
public class VideoRootDto {
    public int id;
    public ArrayList<VideoDto> results;
}
