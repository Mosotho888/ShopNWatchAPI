package com.example.ShopNWatchAPI.model.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private String owner;

    public Favourite() {
    }

    public Favourite(Long id, Movie movie, String owner) {
        this.id = id;
        this.movie = movie;
        this.owner = owner;
    }

}
