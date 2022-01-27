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

import com.projects.mynotepad.model.Event;
import com.projects.mynotepad.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping("all")
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.findAll();
        return new ResponseEntity<>(events,HttpStatus.OK);
    }
    
    @PostMapping("add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event){
        Event newEvent = eventService.add(event);
        return new ResponseEntity<>(newEvent,HttpStatus.CREATED);
    }
    
    @GetMapping("/find-by-user/{userId}")
    public ResponseEntity<List<Event>> getEventsByUserId(@PathVariable("userId") Long userId){
        List<Event> events = eventService.findByUserId(userId);
        return new ResponseEntity<>(events,HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id){
        Event event = eventService.findById(id);
        return new ResponseEntity<>(event,HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event){
        Event updatedEvent = eventService.update(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Long id){
        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
