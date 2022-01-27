package com.projects.mynotepad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.mynotepad.exception.ToDoItemNotFoundException;
import com.projects.mynotepad.model.ToDoItem;
import com.projects.mynotepad.repository.ToDoItemRepository;

@Service
public class ToDoItemService {
    private final ToDoItemRepository toDoItemRepo;

    @Autowired
    public ToDoItemService(ToDoItemRepository toDoItemRepo) {
        this.toDoItemRepo = toDoItemRepo;
    }
    
    public ToDoItem add(ToDoItem toDoItem) {
        return toDoItemRepo.save(toDoItem);
    }
    
    public List<ToDoItem> findAll(){
        return toDoItemRepo.findAll();
    }
    
    public ToDoItem update(ToDoItem toDoItem) {
        return toDoItemRepo.save(toDoItem);
    }
    
    public ToDoItem findById(Long id) {
        return toDoItemRepo.findById(id).orElseThrow(() -> new ToDoItemNotFoundException("To-Do item could not be retrieved from the database with id: " + id));
    }
    
    public List<ToDoItem> findByToDoListId(Long toDoListId) {
        return toDoItemRepo.findByToDoListId(toDoListId);
    }
    
    public void delete(Long id) {
        toDoItemRepo.deleteById(id);
    }
}
