package com.example.ShopNWatchAPI.repository;

import com.example.ShopNWatchAPI.model.movies.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
