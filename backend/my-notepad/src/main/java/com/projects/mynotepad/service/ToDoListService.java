package com.projects.mynotepad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.mynotepad.exception.ToDoListNotFoundException;
import com.projects.mynotepad.model.ToDoList;
import com.projects.mynotepad.repository.ToDoListRepository;

@Service
public class ToDoListService {
    private final ToDoListRepository toDoListRepo;

    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepo) {
        this.toDoListRepo = toDoListRepo;
    }
    
    public ToDoList add(ToDoList toDoList) {
        return toDoListRepo.save(toDoList);
    }
    
    public List<ToDoList> findAll(){
        return toDoListRepo.findAll();
    }
    
    public ToDoList update(ToDoList toDoList) {
        return toDoListRepo.save(toDoList);
    }
    
    public ToDoList findById(Long id) {
        return toDoListRepo.findById(id).orElseThrow(() -> new ToDoListNotFoundException("To Do List could not be retrieved from the database with id: " + id));
    }
    
    public List<ToDoList> findByUserId(Long userId) {
        return toDoListRepo.findByUserId(userId);
    }
    
    public void delete(Long id) {
        toDoListRepo.deleteById(id);
    }
}
