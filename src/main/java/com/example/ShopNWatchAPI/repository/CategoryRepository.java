package com.example.ShopNWatchAPI.repository;

import com.example.ShopNWatchAPI.model.movies.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByNameIgnoreCase(String name);
}
