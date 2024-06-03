package com.example.ShopNWatchAPI.repository;

import com.example.ShopNWatchAPI.model.movies.Favourite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FavouriteRepository extends JpaRepository<Favourite, Long>, PagingAndSortingRepository<Favourite, Long> {
    Favourite findByIdAndOwner(Long id, String owner);
    boolean existsByIdAndOwner(Long id, String owner);
    Page<Favourite> findByOwner(String owner, PageRequest pageRequest);

    //List<Favourite> findByOwner(String user);
}
