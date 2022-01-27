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
import com.projects.mynotepad.model.ToDoItem;
import com.projects.mynotepad.model.ToDoList;
import com.projects.mynotepad.service.ToDoItemService;
import com.projects.mynotepad.service.ToDoListService;

@JsonComponent
public class ToDoItemDeserializer extends StdDeserializer<ToDoItem>{
    
    @Autowired
    ToDoListService toDoListService;
    
    @Autowired
    ToDoItemService toDoItemService;
    
    public ToDoItemDeserializer() {
        this(null);
    }
    
    protected ToDoItemDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ToDoItem deserialize(JsonParser jp, DeserializationContext ctxt) 
            throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        ToDoItem toDoItem = new ToDoItem();
        Long id;
        try {
            id = ((IntNode)node.get("id")).numberValue().longValue();
            toDoItem = toDoItemService.findById(id);
        }
        catch(NullPointerException e) {}
        
        try {
            Long toDoListId = ((IntNode)node.get("toDoList")).numberValue().longValue();
            ToDoList toDoList = toDoListService.findById(toDoListId);
            toDoItem.setToDoList(toDoList);            
        }
        catch(NullPointerException e) {}
        
        try {
            String text = node.get("text").asText();
            toDoItem.setText(text);        
        }
        catch(NullPointerException e) {}

        return toDoItem;
    }
}