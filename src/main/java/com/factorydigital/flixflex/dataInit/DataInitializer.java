package com.factorydigital.flixflex.dataInit;

import com.factorydigital.flixflex.movie.Movie;
import com.factorydigital.flixflex.movie.MovieDto;
import com.factorydigital.flixflex.movie.MovieMapper;
import com.factorydigital.flixflex.movie.MovieRepository;
import com.factorydigital.flixflex.tvShow.TvShow;
import com.factorydigital.flixflex.tvShow.TvShowDto;
import com.factorydigital.flixflex.tvShow.TvShowMapper;
import com.factorydigital.flixflex.tvShow.TvShowsRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final String IMDB_API_URL = "https://api.themoviedb.org/3/discover/%s?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc";
    private final String IMDB_TRAILER_VIDEOS_URL = "https://api.themoviedb.org/3/movie/%d/videos";
    private final String YOUTUBE_URL = "https://www.youtube.com/watch?v=%s";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TvShowsRepository tvShowsRepository;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private TvShowMapper tvShowMapper;

    @Override
    public void run(String... args) throws Exception {
        if (movieRepository.count() == 0) {
            List<Movie> movies = fetchMovies().stream()
                    .map(movieMapper::toEntity)
                    .peek(e -> e.setTrailerUrl(fetchMoviesTrailerUrl(e.getId()))).toList();
            movieRepository.saveAll(movies);
        }
        if (tvShowsRepository.count() == 0) {
            List<TvShow> tvShows = fetchTvShows().stream().map(tvShowMapper::toEntity).toList();
            tvShowsRepository.saveAll(tvShows);
        }

    }

    public ArrayList<MovieDto> fetchMovies() {
        String moviesApiUrl = String.format(IMDB_API_URL, "movie");
        MovieRootDto data = restTemplate.getForObject(moviesApiUrl, MovieRootDto.class);
        assert data != null;
        return data.getResults();
    }

    public ArrayList<TvShowDto> fetchTvShows() {
        String tvShowsApiUrl = String.format(IMDB_API_URL, "tv");
        TvShowRootDto data = restTemplate.getForObject(tvShowsApiUrl, TvShowRootDto.class);
        assert data != null;
        return data.getResults();
    }

    public String fetchMoviesTrailerUrl(Long movieId) {
        String movieFetchVideoUrl = String.format(IMDB_TRAILER_VIDEOS_URL, movieId);
        VideoRootDto data = restTemplate.getForObject(movieFetchVideoUrl, VideoRootDto.class);
        System.out.println("the fetching url is ==> " + movieFetchVideoUrl);
        assert data != null;
        VideoDto videoDto = data.getResults().stream().filter(e -> e.site.equalsIgnoreCase("YouTube") && e.type.equalsIgnoreCase("Trailer")).findFirst().get();
        return String.format(YOUTUBE_URL, videoDto.key);
    }
}
