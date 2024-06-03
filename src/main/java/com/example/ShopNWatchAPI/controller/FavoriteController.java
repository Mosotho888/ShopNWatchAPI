package com.example.ShopNWatchAPI.controller;

import com.example.ShopNWatchAPI.model.movies.Favourite;
import com.example.ShopNWatchAPI.service.FavouriteService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/favourites")
public class FavoriteController {
    private final FavouriteService favouriteService;

    public FavoriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @GetMapping
    private ResponseEntity<List<Favourite>> findAll(Pageable pageable, Principal principal) {
        return favouriteService.findAll(pageable, principal);
    }
}
