package com.notes.notesapp.service;

import com.notes.notesapp.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User registerUser(User user);
    void deleteUser(Long id);
}
