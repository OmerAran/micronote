package com.omeraran.service;

import com.omeraran.dto.UserDto;
import com.omeraran.dto.converter.UserDtoConverter;
import com.omeraran.exception.UserNotFoundException;
import com.omeraran.model.User;
import com.omeraran.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       UserDtoConverter userDtoConverter,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto getOneUser(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("[getOneUser] user not found with id: " + id));
        UserDto userDto = userDtoConverter.converter(user);
        return userDto;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users
                .stream()
                .map(userDtoConverter::converter)
                .collect(Collectors.toList());
        return userDtos;
    }

    public UserDto saveOneUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        UserDto userDto = userDtoConverter.converter(savedUser);
        return userDto;
    }

    public UserDto updateOneUser(User updatedUser) {

        User user = userRepository
                .findById(updatedUser.getId())
                .orElseThrow(() -> new UserNotFoundException("[updateOneUser] user not found with id: "
                        + updatedUser.getId()));

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        UserDto userDto = userDtoConverter.converter(userRepository.save(user));
        return userDto;
    }

    public void deleteOneUser(Long id) {
        userRepository.deleteById(id);
    }
}
