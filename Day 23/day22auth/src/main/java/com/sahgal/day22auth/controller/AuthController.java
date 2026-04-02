package com.sahgal.day22auth.controller;

import com.sahgal.day22auth.entity.User;
import com.sahgal.day22auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        service.register(user);
        return "User Registered Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data) {
        service.login(data.get("email"), data.get("password"));
        return "Login Successful";
    }

    @PostMapping("/logout")
    public String logout() {
        return "Logout Successful";
    }
}