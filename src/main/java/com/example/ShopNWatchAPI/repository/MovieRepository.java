package com.example.ShopNWatchAPI.repository;

import com.example.ShopNWatchAPI.model.movies.Category;
import com.example.ShopNWatchAPI.model.movies.Favourite;
import com.example.ShopNWatchAPI.model.movies.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.ResponseBody;

public interface MovieRepository extends JpaRepository<Movie, Long>, PagingAndSortingRepository<Movie, Long> {
    Page<Movie> findByCategory(Category category, PageRequest pageRequest);
    Page<Movie> findByReleaseYear(int releaseYear, PageRequest pageRequest);
    Page<Movie> searchByTitle(String title, PageRequest pageRequest);
}
