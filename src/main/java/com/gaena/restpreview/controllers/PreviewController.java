package com.gaena.restpreview.controllers;

import com.gaena.restpreview.model.User;
import com.gaena.restpreview.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PreviewController {

    private UserService userService;


    public PreviewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @PostMapping("/save")
    public User addUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
}
