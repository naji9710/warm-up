package com.before.control.warmup.serviceTests;

import com.before.control.warmup.WarmUpApplication;
import com.before.control.warmup.models.User;
import com.before.control.warmup.repositories.UserRepository;
import com.before.control.warmup.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = WarmUpApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    User user1 = new User();
    User user2 = new User();

    @Test
    public void getUserByIdTest() {
        user1.setRole("ADMIN");
        user1.setLogin("ADMIN");
        user1.setPassword("ADMIN");
        userRepository.save(user1);

        User user = userService.getUserById(user1.getId());

        assertEquals("ADMIN", user.getLogin(), "1111111111");
        assertEquals("ADMIN", user.getPassword(), "222222");
        assertEquals("ADMIN", user.getRole(), "33333333");
    }

    @Test
    public void saveUserTest() {
        user1.setRole("ADMIN");
        user1.setLogin("ADMIN");
        user1.setPassword("ADMIN");
        userService.save(user1);

        System.out.println(user1.getId());
        User user = userService.getUserById(user1.getId());

        assertEquals("ADMIN", user.getLogin(), "1111111");
        assertEquals("ADMIN", user.getPassword(), "222222");
        assertEquals("ADMIN", user.getRole(), "33333333");
    }

    @Test
    public void GetAllUsersTest() {
        user1.setRole("ADMIN");
        user1.setLogin("ADMIN");
        user1.setPassword("ADMIN");
        userService.save(user1);

        user2.setRole("USER");
        user2.setLogin("USER");
        user2.setPassword("USER");
        userService.save(user2);

        ArrayList<User> users = userService.getAllUsers();

        for (User user : users) {
            if (user.getId() == user1.getId()) {
                assertEquals("ADMIN", user.getLogin(), "1111111");
                assertEquals("ADMIN", user.getPassword(), "222222");
                assertEquals("ADMIN", user.getRole(), "33333333");
            }
            if (user.getId() == user2.getId()) {
                assertEquals("USER", user.getLogin(), "44444444");
                assertEquals("USER", user.getPassword(), "55555");
                assertEquals("USER", user.getRole(), "6666666");
            }
        }

    }

    @Test
    public void createAdminAndUserTest() {
        userService.createAdminAndUser();

        ArrayList<User> users = userService.getAllUsers();

        for (User user : users) {
            if (user.getRole().equals("ADMIN")) {
                assertEquals("ADMIN", user.getLogin(), "1111111");
                assertEquals("ADMIN", user.getPassword(), "222222");
            }
            if (user.getRole().equals("USER")) {
                assertEquals("USER", user.getLogin(), "44444444");
                assertEquals("USER", user.getPassword(), "55555");
            }
        }


    }
}
