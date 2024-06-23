package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.services.UserService;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.util.UserValidator;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
    }

    @GetMapping
    public String user(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}
