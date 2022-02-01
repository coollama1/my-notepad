package com.projects.mynotepad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.mynotepad.model.ToDoList;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    @Override
    void deleteById(Long id);
    @Override
    Optional<ToDoList> findById(Long id);
    List<ToDoList> findByUserId(Long userId);
}
