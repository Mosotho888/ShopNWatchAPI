package com.example.ShopNWatchAPI.repository;

import com.example.ShopNWatchAPI.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
