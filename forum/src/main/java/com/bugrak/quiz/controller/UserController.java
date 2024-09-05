package com.bugrak.quiz.controller;

import com.bugrak.quiz.entities.User;
import com.bugrak.quiz.repository.UserRepositoy;
import com.bugrak.quiz.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User newUser) {
        return userService.saveOneuser(newUser);
    }

    @GetMapping("/getById/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.findByUserId(userId);
    }

    @PutMapping("/update/{userId}")
    public User updateOneUser(@PathVariable int userId, @RequestBody User updatedUser) {
        return userService.updateOneUser(userId,updatedUser);
    }
}
