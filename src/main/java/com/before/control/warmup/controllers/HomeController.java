package com.before.control.warmup.controllers;

import com.before.control.warmup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping
    public String home() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home1(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null){
            return "login";
        }
        else {
            model.addAttribute("role",httpSession.getAttribute("user"));
            return "home";
        }
    }

}
