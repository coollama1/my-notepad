package com.projects.mynotepad.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.mynotepad.model.Note;
import com.projects.mynotepad.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    
    @GetMapping("all")
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes = noteService.findAll();
        return new ResponseEntity<>(notes,HttpStatus.OK);
    }
    
    @PostMapping("add")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        Note newNote = noteService.add(note);
        return new ResponseEntity<>(newNote,HttpStatus.CREATED);
    }
    
    @GetMapping("/find-by-user/{userId}")
    public ResponseEntity<List<Note>> getNotesByUserId(@PathVariable("userId") Long userId){
        List<Note> notes = noteService.findByUserId(userId);
        return new ResponseEntity<>(notes,HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id){
        Note note = noteService.findById(id);
        return new ResponseEntity<>(note,HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        Note updatedNote = noteService.save(note);
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") Long id){
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
