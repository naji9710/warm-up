package com.before.control.warmup.services.serviceImpl;

import com.before.control.warmup.models.User;
import com.before.control.warmup.repositories.UserRepository;
import com.before.control.warmup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public void createAdminAndUser() {
        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        if (users.size() == 0) {
            User admin = new User();
            admin.setRole("ADMIN");
            admin.setLogin("ADMIN");
            admin.setPassword("ADMIN");
            userRepository.save(admin);

            User user = new User();
            user.setRole("USER");
            user.setLogin("USER");
            user.setPassword("USER");
            userRepository.save(user);
        }
    }

    @Override
    public User verify(String login, String password) {
        ArrayList<User> users = (ArrayList<User>) userRepository.findAllByLogin(login);

        if (users.size() > 0 && users.get(0).getPassword().equals(password)) {
            return users.get(0);
        }
        return null;
    }
}
