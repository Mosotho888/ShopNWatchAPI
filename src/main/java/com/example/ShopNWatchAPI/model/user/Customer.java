package com.example.ShopNWatchAPI.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer() {
    }

    public Customer(Long id, String full_name, String email, String password, Address address) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

}
