package com.example.ShopNWatchAPI.controller;

import com.example.ShopNWatchAPI.model.movies.Movie;
import com.example.ShopNWatchAPI.service.MovieService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> fillAllMovies(Pageable pageable){
        return movieService.findAllMovies(pageable);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> fillByMovieId(@PathVariable Long movieId) {
        return movieService.findByMovieId(movieId);
    }

    @PostMapping
    public ResponseEntity<Void> addMovie(@RequestBody Movie newMovie, UriComponentsBuilder ucb){
        return movieService.addMovie(newMovie, ucb);
    }
}
