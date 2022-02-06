package com.project.moviedateServer.controller;

import com.project.moviedateServer.exception.ResourceNotFoundException;
import com.project.moviedateServer.model.User;
import com.project.moviedateServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){ return userRepository.findAll(); }

    @GetMapping("/find/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username") String username) throws Exception {
        User user = userRepository.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("User not found for this id : "+ username));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/addUser")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

}
