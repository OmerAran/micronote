package com.omeraran.controller;

import com.omeraran.dto.UserDto;
import com.omeraran.dto.converter.UserDtoConverter;
import com.omeraran.model.User;
import com.omeraran.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    public UserController(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    @GetMapping("/{id}")
    public UserDto getOneUserInfo(@PathVariable Long id){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException());
        UserDto userDto = userDtoConverter.converter(user);
        return userDto;
    }

    @PostMapping("/add")
    public User saveOneUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
