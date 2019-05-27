package com.gaena.restpreview.controllers;

import com.gaena.restpreview.model.User;
import com.gaena.restpreview.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PreviewController {

    private UserService userService;


    public PreviewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public void getUser() {

    }

    @GetMapping("/getAllUsers")
    public void getUserList() {

    }

    @PostMapping("/save")
    public void addUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/update")
    public void updateUser() {

    }

    @DeleteMapping("/delete")
    public void deleteUser() {

    }
}
