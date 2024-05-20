package com.example.ShopNWatchAPI.component;

import com.example.ShopNWatchAPI.model.Movie;
import com.example.ShopNWatchAPI.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DummyMovieData implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public DummyMovieData(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Delete all existing movies (optional)
        movieRepository.deleteAll();

        // Create dummy movies
        List<Movie> movies = Arrays.asList(
                new Movie(null, "Inception", 9, "English"),
                new Movie(null, "The Shawshank Redemption", 10, "English"),
                new Movie(null, "Parasite", 8, "Korean")
                // Add more movies as needed
        );

        // Save dummy movies to the database
        movieRepository.saveAll(movies);
    }
}
