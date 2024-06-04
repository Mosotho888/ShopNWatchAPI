package com.example.ShopNWatchAPI.service;

import com.example.ShopNWatchAPI.model.movies.*;
import com.example.ShopNWatchAPI.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ResponseEntity<List<Movie>> findAllMovies(Pageable pageable) {
        Page<Movie> page = movieRepository.findAll(PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize()
        ));
        return ResponseEntity.ok(page.getContent());
    }

    public ResponseEntity<List<Movie>> findByCategory(Category category, Pageable pageable){
        Page<Movie> page = movieRepository.findByCategory(category,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                ));
        return ResponseEntity.ok(page.getContent());
    }

    public ResponseEntity<Optional<Movie>> findByMovieId(Long movieId){
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()){
            return ResponseEntity.ok(movie);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> addMovie(Movie newMovie, UriComponentsBuilder ucb){
        Movie movie = new Movie(null,
                newMovie.getTitle(),
                newMovie.getRating(),
                newMovie.getReleaseYear(),
                newMovie.getLanguage(),
                newMovie.getCategory(),
                newMovie.getActor());
        Movie addedMovie = movieRepository.save(movie);

        URI locationOfNewMovie = ucb
                .path("movie/{id}")
                .buildAndExpand(addedMovie.getId())
                .toUri();

        return ResponseEntity.created(locationOfNewMovie).build();
    }

    public ResponseEntity<Void> updateMovie(Movie movieUpdated, long movieId){
        Optional<Movie> movie = movieRepository.findById(movieId);

        if (movie.isPresent()){
            Movie updatedMovie = new Movie(movieId,
                    movieUpdated.getTitle(),
                    movieUpdated.getRating(),
                    movieUpdated.getReleaseYear(),
                    movieUpdated.getLanguage(),
                    movieUpdated.getCategory(),
                    movieUpdated.getActor());
            movieRepository.save(updatedMovie);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteMovie(Long movieId){
        if (movieRepository.existsById(movieId)){
            movieRepository.deleteById(movieId);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
