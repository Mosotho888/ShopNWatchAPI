package com.example.ShopNWatchAPI.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;

    public Actor() {
    }

    public Actor(Long id, String full_name) {
        this.id = id;
        this.full_name = full_name;
    }

    public Long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
