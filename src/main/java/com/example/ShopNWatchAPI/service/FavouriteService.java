package com.example.ShopNWatchAPI.service;

import com.example.ShopNWatchAPI.model.movies.Favourite;
import com.example.ShopNWatchAPI.repository.FavouriteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class FavouriteService {
    private final FavouriteRepository favouriteRepository;

    public FavouriteService(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    public ResponseEntity<List<Favourite>> findAll(Pageable pageable, Principal principal){
         Page<Favourite> page = favouriteRepository.findByOwner(principal.getName(),
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))
                ));
        return ResponseEntity.ok(page.getContent());
    }
}
