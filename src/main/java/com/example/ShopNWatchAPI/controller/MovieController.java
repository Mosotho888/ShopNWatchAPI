package com.example.ShopNWatchAPI.controller;

import com.example.ShopNWatchAPI.model.movies.Movie;
import com.example.ShopNWatchAPI.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> fillAllMovies(){
        return movieService.findAllMovies();
    }
}
