package com.notes.notesapp.service.impl;

import com.notes.notesapp.exception.UserNotFoundException;
import com.notes.notesapp.model.User;
import com.notes.notesapp.repository.UserRepository;
import com.notes.notesapp.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        log.info("Fetching user with id {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User registerUser(User user) {
        log.info("Registering user {}", user.getUsername());
       
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        log.warn("Deleting user with id {}", id);
        userRepository.deleteById(id);
    }
}
