package com.factorydigital.flixflex.dataInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        String apiUrl = "https://api.themoviedb.org/3/discover/%s?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc";
        String moviesApiUrl = String.format(apiUrl, "movie");
        String seriesApiUrl = String.format(apiUrl, "tv");
        RootDto data = restTemplate.getForObject(seriesApiUrl, RootDto.class);
        System.out.println(data);
    }
}
