package com.before.control.warmup.controllers;

import com.before.control.warmup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping
    public String home() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home1() {
        userService.createAdminAndUser();
        return "home";
    }

}
