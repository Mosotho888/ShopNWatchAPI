package com.example.ShopNWatchAPI.model.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private int ReleaseYear;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    public Movie() {
    }

    public Movie(Long id, String title, int rating, int ReleaseYear, Language language, Category category, Actor actor) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.ReleaseYear = ReleaseYear;
        this.language = language;
        this.category = category;
        this.actor = actor;
    }

}
