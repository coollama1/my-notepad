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
import com.projects.mynotepad.model.User;
import com.projects.mynotepad.service.UserService;

@JsonComponent
public class UserDeserializer extends StdDeserializer<User> {
    
    @Autowired
    UserService userService;
    
    public UserDeserializer() {
        this(null);
    }
    
    protected UserDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public User deserialize(JsonParser jp, DeserializationContext ctxt) 
            throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        User user = new User();
        Long id;
        try {
            id = ((IntNode)node.get("id")).numberValue().longValue();
            user = userService.findById(id);
        }
        catch(NullPointerException e) {}
        
        try {
            String username = node.get("username").asText();
            user.setUsername(username);
        }
        catch(NullPointerException e) {}
        
        try {
            String name = node.get("name").asText();
            user.setName(name);
        }
        catch(NullPointerException e) {}
        
        return user;
    }

}
