package com.example.ShopNWatchAPI.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String houseNumberAndStreetName;
    @Setter
    private String address2;
    @Setter
    @ManyToOne
    @JoinColumn(name = "city_ìd")
    private City city;
    @Setter
    private String phoneNumber;

    public Address(Long id, String houseNumberAndStreetName, String address2, City city, String phoneNumber) {
        this.id = id;
        this.houseNumberAndStreetName = houseNumberAndStreetName;
        this.address2 = address2;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

}
