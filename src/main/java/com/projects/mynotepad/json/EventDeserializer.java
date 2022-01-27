package com.projects.mynotepad.json;

import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.projects.mynotepad.model.Event;
import com.projects.mynotepad.service.EventService;
import com.projects.mynotepad.service.UserService;

@JsonComponent
public class EventDeserializer extends StdDeserializer<Event>{

    @Autowired
    UserService userService;
    
    @Autowired
    EventService eventService;
    
    public EventDeserializer() {
        this(null);
    }
    
    protected EventDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Event deserialize(JsonParser jp, DeserializationContext ctxt) 
            throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        Event event = new Event();
        Long id;
        try {
            id = ((IntNode)node.get("id")).numberValue().longValue();
            event = eventService.findById(id);
        }
        catch(NullPointerException e) {}
        
        try {
            String name = node.get("name").asText();
            event.setName(name);
        }catch(NullPointerException e) {}
        
        try {
            String description = node.get("description").asText();
            event.setDescription(description);
        }catch(NullPointerException e) {}

        try {
            String timeString = node.get("time").asText(); 
            Date time = Date.valueOf(timeString);
            event.setTime(time);
        }catch(NullPointerException e) {}
        
        try {
            Long userId = ((IntNode)node.get("user")).numberValue().longValue();
            event.setUser(userService.findById(userId));
        }catch(NullPointerException e) {}
        
        return event;
    }

}
