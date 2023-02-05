package com.omeraran.controller;

import com.omeraran.dto.UserDto;
import com.omeraran.model.User;
import com.omeraran.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public UserDto getOneUser(@PathVariable Long id){
        UserDto user = userService.getOneUser(id);
        return user;
    }

    @PostMapping("/add")
    public UserDto saveOneUser(@RequestBody User user){
        UserDto userDto = userService.saveOneUser(user);
        return userDto;
    }
    @PutMapping("/edit")
    public UserDto updateOneUser(@RequestBody User user){
        UserDto updatedUser = userService.updateOneUser(user);
        return updatedUser;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOneUser(@PathVariable Long id){
        userService.deleteOneUser(id);
    }

}
