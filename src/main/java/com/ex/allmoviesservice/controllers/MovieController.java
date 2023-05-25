package com.ex.allmoviesservice.controllers;

import com.ex.allmoviesservice.entities.Movie;
import com.ex.allmoviesservice.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/v1")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping(value="search/movie")
    public ResponseEntity<Movie> getMovies(@PathParam("movieName") String movieName ) {
        return new ResponseEntity<>(movieService.searchMoviaByName(movieName), HttpStatus.OK);
    }

}
