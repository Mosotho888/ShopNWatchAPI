package com.example.ShopNWatchAPI.service;

import com.example.ShopNWatchAPI.model.movies.Movie;
import com.example.ShopNWatchAPI.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
}
