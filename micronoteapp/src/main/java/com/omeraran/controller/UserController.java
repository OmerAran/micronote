package com.omeraran.controller;

import com.omeraran.dto.UserDto;
import com.omeraran.model.User;
import com.omeraran.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDto> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/{id}")
    public UserDto getOneUser(@PathVariable Long id) {
        UserDto user = userService.getOneUser(id);
        return user;
    }

    @PostMapping("/add")
    public UserDto saveOneUser(@RequestBody User user) {
        UserDto userDto = userService.saveOneUser(user);
        return userDto;
    }

    @PutMapping("/edit")
    public UserDto updateOneUser(@RequestBody User user) {
        UserDto updatedUser = userService.updateOneUser(user);
        return updatedUser;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneUser(@PathVariable Long id) {
        userService.deleteOneUser(id);
    }

}
