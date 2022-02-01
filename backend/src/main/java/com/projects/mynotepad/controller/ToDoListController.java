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

import com.projects.mynotepad.model.ToDoItem;
import com.projects.mynotepad.model.ToDoList;
import com.projects.mynotepad.service.ToDoItemService;
import com.projects.mynotepad.service.ToDoListService;

@RestController
@RequestMapping("/todolist")
public class ToDoListController {
    private final ToDoListService toDoListService;
    private final ToDoItemService toDoItemService;

    public ToDoListController(ToDoListService toDoListService, ToDoItemService toDoItemService) {
        this.toDoListService = toDoListService;
        this.toDoItemService = toDoItemService;
    }
    
    @GetMapping("all")
    public ResponseEntity<List<ToDoList>> getAllToDoLists(){
        List<ToDoList> toDoLists = toDoListService.findAll();
        return new ResponseEntity<>(toDoLists,HttpStatus.OK);
    }
    
    @PostMapping("add")
    public ResponseEntity<ToDoList> addToDoList(@RequestBody ToDoList toDoList){
        ToDoList newToDoList = toDoListService.add(toDoList);
        return new ResponseEntity<>(newToDoList,HttpStatus.CREATED);
    }
    
    @PostMapping("add-item")
    public ResponseEntity<ToDoItem> addToDoListItem(@RequestBody ToDoItem toDoItem){
        ToDoItem newToDoItem = toDoItemService.add(toDoItem);
        return new ResponseEntity<>(newToDoItem,HttpStatus.CREATED);
    }
    
    @GetMapping("/find-by-user/{userId}")
    public ResponseEntity<List<ToDoList>> getToDoListsByUserId(@PathVariable("userId") Long userId){
        List<ToDoList> toDoLists = toDoListService.findByUserId(userId);
        return new ResponseEntity<>(toDoLists,HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<ToDoList> getToDoListById(@PathVariable("id") Long id){
        ToDoList toDoList = toDoListService.findById(id);
        return new ResponseEntity<>(toDoList,HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<ToDoList> updateToDoList(@RequestBody ToDoList toDoList){
        ToDoList newToDoList = toDoListService.update(toDoList);
        return new ResponseEntity<>(newToDoList, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteToDoList(@PathVariable("id") Long id){
        toDoListService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
