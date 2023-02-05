package com.omeraran.service;

import com.omeraran.dto.UserDto;
import com.omeraran.dto.converter.UserDtoConverter;
import com.omeraran.model.User;
import com.omeraran.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public UserDto getOneUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        UserDto userDto = userDtoConverter.converter(user);
        return userDto;
    }

    public UserDto saveOneUser(User user){
        User savedUser = userRepository.save(user);
        UserDto userDto = userDtoConverter.converter(savedUser);
        return userDto;
    }

    public UserDto updateOneUser(User updatedUser){
        User user = userRepository.findById(updatedUser.getId()).orElseThrow(()->new RuntimeException());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        UserDto userDto = userDtoConverter.converter(userRepository.save(user));
        return userDto;
    }

    public void deleteOneUser(Long id){
        userRepository.deleteById(id);
    }
}
