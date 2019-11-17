package com.before.control.warmup.services;

import com.before.control.warmup.models.User;

import java.util.ArrayList;

public interface UserService {
    void save(User user);

    User getUserById(Long id);

    ArrayList<User> getAllUsers();

    void createAdminAndUser();

    User verify(String login, String password);
}
