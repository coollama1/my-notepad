package com.projects.mynotepad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.mynotepad.exception.EventNotFoundException;
import com.projects.mynotepad.model.Event;
import com.projects.mynotepad.repository.EventRepository;

@Service
public class EventService {

    private final EventRepository eventRepo;

    @Autowired
    public EventService(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }
    
    public Event add(Event event) {
        return eventRepo.save(event);
    }
    
    public List<Event> findAll(){
        return eventRepo.findAll();
    }
    
    public Event update(Event event) {
        return eventRepo.save(event);
    }
    
    public Event findById(Long id) {
        return eventRepo.findById(id).orElseThrow(() -> new EventNotFoundException("Event could not be retrieved from the database with id: " + id));
    }
    
    public List<Event> findByUserId(Long userId) {
        return eventRepo.findByUserId(userId);
    }
    
    public void delete(Long id) {
        eventRepo.deleteById(id);
    }
}
