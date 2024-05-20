package com.example.ShopNWatchAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String full_name;
    @Setter
    private String email;
    @Setter
    private String password;

    public User() {
    }

    public User(Long id, String full_name, String email, String password) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
    }

}
