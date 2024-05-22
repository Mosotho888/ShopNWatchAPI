package com.example.ShopNWatchAPI.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String cityName;
    @Setter
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City(Long id, String cityName, Country country) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
    }

}
