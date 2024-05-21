package com.example.ShopNWatchAPI.component;

import com.example.ShopNWatchAPI.model.Actor;
import com.example.ShopNWatchAPI.model.Category;
import com.example.ShopNWatchAPI.model.Language;
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
                new Movie(null, "Inception", 9,
                        new Language(null, "English"),
                        new Category(null, "Action"),
                        new Actor(null, "Tebogo Mofokeng")),
                new Movie(null, "The Shawshank Redemption", 10,
                        new Language(null, "Sesotho"),
                        new Category(null, "Comedy"),
                        new Actor(null, "Tebu")),
                new Movie(null, "Parasite", 8,
                        new Language(null, "Korean"),
                        new Category(null, "Horror"),
                        new Actor(null, "Lefu"))
                // Add more movies as needed
        );

        // Save dummy movies to the database
        movieRepository.saveAll(movies);
    }
}
