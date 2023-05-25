package com.ex.allmoviesservice.services;


import com.ex.allmoviesservice.entities.Movie;
import com.ex.allmoviesservice.entities.MovieDB;
import com.ex.allmoviesservice.entities.MovieDBResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class TheMovieDb {
    @Value(value = "${THEMOVIEDB_API_KEY}")
    private String MOVIE_DB_API_KEY;
    private static final Logger LOGGER = LoggerFactory.getLogger(TheMovieDb.class);
    private static final String URL = "https://api.themoviedb.org/3/";

    public Movie searchMovieByName(String movieName) {
        // https://developers.themoviedb.org/3/getting-started/search-and-query-for-details
        //search/movie?api_key=7a95be8446cfdcaef6da48bbf0ab7bbe&query=Jack+Reacher
        String treatedMovieName = movieName.trim().replaceAll(Pattern.quote(" "), "+");

        String finalUrl = URL + "search/movie?api_key=" + MOVIE_DB_API_KEY + "&query=" + treatedMovieName;
        LOGGER.info("Searching at themoviedb.com for: {}", treatedMovieName);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MovieDBResponseEntity> response =
                restTemplate.getForEntity(finalUrl, MovieDBResponseEntity.class);
        if ( HttpStatus.OK != response.getStatusCode() || !response.hasBody() || response.getBody().getResults().isEmpty()){
            return null;
        }

        MovieDB newMovie = response.getBody().getResults().get(0);
        if(Objects.equals(newMovie.getTitle(), movieName)){
            Movie movie = new Movie();
            movie.setTitle(newMovie.getTitle());
            movie.setDescription(newMovie.getOverview());
            return movie;
        }
        return null;
    }

}
