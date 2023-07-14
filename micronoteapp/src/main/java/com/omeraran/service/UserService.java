package com.omeraran.service;

import com.omeraran.dto.UserDto;
import com.omeraran.dto.converter.UserDtoConverter;
import com.omeraran.exception.UserNotFoundException;
import com.omeraran.model.User;
import com.omeraran.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return userDtoConverter.converter(user);
    }

    public List<UserDto> getAllUsers(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<User> users = userRepository.findAll(paging);
        return userDtoConverter.converter(users.getContent());
    }

    public UserDto saveOneUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return userDtoConverter.converter(savedUser);
    }

    public UserDto updateOneUser(User updatedUser) {

        User user = userRepository
                .findById(updatedUser.getId())
                .orElseThrow(() -> new UserNotFoundException("[updateOneUser] user not found with id: "
                        + updatedUser.getId()));

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        return userDtoConverter.converter(userRepository.save(user));
    }

    public void deleteOneUser(Long id) {
        userRepository.deleteById(id);
    }
}
