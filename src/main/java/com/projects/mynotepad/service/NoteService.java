package com.projects.mynotepad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.mynotepad.exception.NoteNotFoundException;
import com.projects.mynotepad.model.Note;
import com.projects.mynotepad.repository.NoteRepository;

@Service
public class NoteService {
    private final NoteRepository noteRepo;

    @Autowired
    public NoteService(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }
    
    public Note add(Note note) {
        return noteRepo.save(note);
    }
    
    public List<Note> findAll(){
        return noteRepo.findAll();
    }
    
    public Note save(Note note) {
        return noteRepo.save(note);
    }
    
    public Note findById(Long id) {
        return noteRepo.findById(id).orElseThrow(() -> new NoteNotFoundException("Note could not be retrieved from the database with id: " + id));
    }
    
    public List<Note> findByUserId(Long userId) {
        return noteRepo.findByUserId(userId);
    }
    
    public void delete(Long id) {
        noteRepo.deleteById(id);
    }
}
