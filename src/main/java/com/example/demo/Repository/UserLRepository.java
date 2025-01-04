package com.example.demo.Repository;


import com.example.demo.Entities.UserL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLRepository extends JpaRepository<UserL, Long> {
    Optional<UserL> findByEmail(String email);
}