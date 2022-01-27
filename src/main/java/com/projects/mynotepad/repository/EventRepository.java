package com.projects.mynotepad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.mynotepad.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Override
    void deleteById(Long id);
    @Override
    Optional<Event> findById(Long id);
    
    List<Event> findByUserId(Long userId);
    
}
