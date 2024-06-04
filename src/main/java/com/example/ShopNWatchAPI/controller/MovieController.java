package com.example.ShopNWatchAPI.controller;

import com.example.ShopNWatchAPI.model.movies.Category;
import com.example.ShopNWatchAPI.model.movies.Favourite;
import com.example.ShopNWatchAPI.model.movies.Movie;
import com.example.ShopNWatchAPI.repository.CategoryRepository;
import com.example.ShopNWatchAPI.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private CategoryRepository categoryRepository;

    public MovieController(MovieService movieService, CategoryRepository categoryRepository) {
        this.movieService = movieService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> fillAllMovies(Pageable pageable){
        return movieService.findAllMovies(pageable);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Movie>> findByCategory(@RequestParam("category") String categoryName, Pageable pageable){
        Category category =categoryRepository.findByNameIgnoreCase(categoryName);

        return movieService.findByCategory(category, pageable);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<Movie>> fillByMovieId(@PathVariable Long movieId) {
        return movieService.findByMovieId(movieId);
    }

    @PostMapping
    public ResponseEntity<Void> addMovie(@RequestBody Movie newMovie, UriComponentsBuilder ucb){
        return movieService.addMovie(newMovie, ucb);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Void> updateMovie(@RequestBody Movie movieUpdated, @PathVariable Long movieId){
        return movieService.updateMovie(movieUpdated, movieId);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId){
        return movieService.deleteMovie(movieId);
    }
}
