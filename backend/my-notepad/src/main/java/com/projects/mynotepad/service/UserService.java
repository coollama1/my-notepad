package com.projects.mynotepad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.mynotepad.exception.UserNotFoundException;
import com.projects.mynotepad.model.User;
import com.projects.mynotepad.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepo;
    private static final String USER_NOT_FOUND_MESSAGE = "User could not be retrieved from the database ";

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    public User add(User user) {
        return userRepo.save(user);
    }
    
    public List<User> findAll(){
        return userRepo.findAll();
    }
    
    public User update(User user) {
        return userRepo.save(user);
    }
    
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE + ", id: "+  id));
    }
    
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE + ", username = " + username));
    }
    
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
