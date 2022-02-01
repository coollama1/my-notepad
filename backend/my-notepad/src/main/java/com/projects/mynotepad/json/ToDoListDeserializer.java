package com.projects.mynotepad.json;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.projects.mynotepad.model.ToDoList;
import com.projects.mynotepad.service.ToDoItemService;
import com.projects.mynotepad.service.ToDoListService;
import com.projects.mynotepad.service.UserService;

@JsonComponent
public class ToDoListDeserializer extends StdDeserializer<ToDoList> {

    @Autowired
    UserService userService;
    
    @Autowired
    ToDoItemService toDoItemService;
    
    @Autowired
    ToDoListService toDoListService;
    
    public ToDoListDeserializer() {
        this(null);
    }
    
    protected ToDoListDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ToDoList deserialize(JsonParser jp, DeserializationContext ctxt) 
            throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        ToDoList toDoList = new ToDoList();
        Long id;
        try {
            id = ((IntNode)node.get("id")).numberValue().longValue();
            toDoList = toDoListService.findById(id);
        }
        catch(NullPointerException e) {}
        
        try {
            String name = node.get("name").asText();
            toDoList.setName(name);
        }
        catch(NullPointerException e) {}
        
        try {
            String description = node.get("description").asText();
            toDoList.setDescription(description);
        }
        catch(NullPointerException e) {}
        
        try {
            Long userId = ((IntNode)node.get("user")).numberValue().longValue();
            toDoList.setUser(userService.findById(userId));
        }
        catch(NullPointerException e) {}

        return toDoList;
    }

}
