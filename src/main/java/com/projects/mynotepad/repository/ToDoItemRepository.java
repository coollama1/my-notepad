package com.projects.mynotepad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.mynotepad.model.ToDoItem;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long>{
    @Override
    void deleteById(Long id);
    @Override
    Optional<ToDoItem> findById(Long id);
    List<ToDoItem> findByToDoListId(Long toDoListId);
}
