package com.projects.mynotepad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.mynotepad.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
    @Override
    void deleteById(Long id);
    @Override
    Optional<Note> findById(Long id);
    List<Note> findByUserId(Long userId);
}
