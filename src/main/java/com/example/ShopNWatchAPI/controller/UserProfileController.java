package com.example.ShopNWatchAPI.controller;

import com.example.ShopNWatchAPI.model.user.Customer;
import com.example.ShopNWatchAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<Customer>> findAllUsers(Pageable pageable) {
        return userService.findAllUsers(pageable);
    }
}
