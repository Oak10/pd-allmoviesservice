package com.ex.allmoviesservice.services;

import com.ex.allmoviesservice.entities.Movie;
import com.ex.allmoviesservice.entities.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheMovieDb theMovieDb;

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    public Movie searchMoviaByName(String movieName) {
        Movie movie = movieRepository.findOneByTitle(
                movieName.trim().replaceAll(Pattern.quote("+"), " "));
        if (movie != null){
            LOGGER.info("Found movie [{}] in DB", movieName);
            return movie;
        }
        movie = theMovieDb.searchMovieByName(movieName);
        if( movie == null){
            return null;
        }
        movieRepository.save(movie);
        return movie;
    }

}
