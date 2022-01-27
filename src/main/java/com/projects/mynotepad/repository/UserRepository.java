package com.projects.mynotepad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.mynotepad.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    @Override
    void deleteById(Long id);
    @Override
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
}
