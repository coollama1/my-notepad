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
import com.projects.mynotepad.model.Note;
import com.projects.mynotepad.service.NoteService;
import com.projects.mynotepad.service.UserService;

@JsonComponent
public class NoteDeserializer extends StdDeserializer<Note> {
    @Autowired
    UserService userService;
    
    @Autowired
    NoteService noteService;
    
    public NoteDeserializer() {
        this(null);
    }
    
    protected NoteDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Note deserialize(JsonParser jp, DeserializationContext ctxt) 
            throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        Note note = new Note();
        Long id;
        try {
            id = ((IntNode)node.get("id")).numberValue().longValue();
            note = noteService.findById(id);
        }
        catch(NullPointerException e) {}
        
        try{
            String title = node.get("title").asText();
            note.setTitle(title);
        }
        catch(NullPointerException e) {}
        
        try{
            String text = node.get("text").asText();
            note.setText(text);
        }
        catch(NullPointerException e) {}
        
        try{
            String timeString = node.get("time").asText(); 
            Date time = Date.valueOf(timeString); 
            note.setTime(time);
        }
        catch(NullPointerException e) {}
        
        try {
            Long userId = ((IntNode)node.get("user")).numberValue().longValue();
            note.setUser(userService.findById(userId));            
        }
        catch(NullPointerException e) {}

        return note;
    }
}
