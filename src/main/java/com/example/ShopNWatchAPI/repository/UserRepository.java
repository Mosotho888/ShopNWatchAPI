package com.example.ShopNWatchAPI.repository;

import com.example.ShopNWatchAPI.model.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long> {
}
