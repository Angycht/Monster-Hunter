package com.monster.Monster.Hunter.persistence.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monster.Monster.Hunter.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
