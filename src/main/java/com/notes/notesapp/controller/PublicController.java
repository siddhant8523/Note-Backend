package com.notes.notesapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.notes.notesapp.model.User;
import com.notes.notesapp.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PublicController {
    
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> register(@RequestBody User user) {
        log.info("Registering new user: {}", user.getUsername());
        return ResponseEntity.ok(userService.registerUser(user));
    }
}
