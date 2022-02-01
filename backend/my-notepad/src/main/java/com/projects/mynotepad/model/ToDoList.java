package com.projects.mynotepad.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ToDoList implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private String description;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL)
    private List<ToDoItem> toDoItems;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    
    public ToDoList() {
    }

    public ToDoList(String name, String description, List<ToDoItem> toDoItems, User user) {
        super();
        this.name = name;
        this.description = description;
        this.toDoItems = toDoItems;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(List<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ToDoList [id=" + id + ", name=" + name + ", description=" + description + ", toDoItems=" + toDoItems
                + "]";
    }
    
    
}
