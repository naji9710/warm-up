package com.before.control.warmup.controllers;

import com.before.control.warmup.models.User;
import com.before.control.warmup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login1() {
        userService.createAdminAndUser();
        return "login";
    }

    @PostMapping("/login")
    public String login2(@RequestParam String login, String password, Model model, HttpSession httpSession) {
        User user = userService.verify(login, password);
        if (user == null) {
            model.addAttribute("bad", "**************Wrong Infos***********");
            return "login";
        } else {
            httpSession.setAttribute("user", user);
        }
        return "home";
    }

}
