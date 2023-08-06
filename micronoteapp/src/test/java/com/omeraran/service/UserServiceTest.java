package com.omeraran.service;

import com.omeraran.dto.UserDto;
import com.omeraran.dto.converter.UserDtoConverter;
import com.omeraran.model.ERole;
import com.omeraran.model.Note;
import com.omeraran.model.User;
import com.omeraran.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

class UserServiceTest {

    private UserRepository userRepository;
    private UserDtoConverter userDtoConverter;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userDtoConverter = Mockito.mock(UserDtoConverter.class);
        passwordEncoder = Mockito.mock(PasswordEncoder.class);
        userService = new UserService(userRepository, userDtoConverter, passwordEncoder);
    }

    @Test
    void itShouldReturnUserDtoWithUserById_whenUserIdExists() {
        //given
        Long id = 1L;
        User user = new User(id, "omeraran","123", ERole.ADMIN,null);
        UserDto userDto = userDtoConverter.converter(user);

        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));
        Mockito.when(userDtoConverter.converter(user)).thenReturn(userDto);

        //when
        UserDto result = userService.getOneUser(id);

        //then
        Assertions.assertEquals(userDto, result);
    }

    @Test
    void itShouldReturnUserDtoListWithUserList() {

        //given
        Long id = 1L;

        int pageNo = 0;
        int pageSize = 10;

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Set<Note> notes = new HashSet<>();

        User user = new User(id, "omeraran","123", ERole.ADMIN, null);
        User user2 = new User(2L, "omer","123", ERole.CLIENT, null);

        UserDto userDto = new UserDto(id, "omeraran",ERole.ADMIN, null);
        UserDto userDto2 = new UserDto(2L, "omer",ERole.CLIENT, null);

        List<User> users = List.of(new User[]{user, user2});
        List<UserDto> userDtos = List.of(new UserDto[]{userDto, userDto2});

        Page<User> userPage = new PageImpl<>(users);

        Mockito.when(userRepository.findAll(paging)).thenReturn(userPage);
        Mockito.when(userDtoConverter.converter(userPage.getContent())).thenReturn(userDtos);

        //when
        List<UserDto> result = userService.getAllUsers(pageNo, pageSize);
        //then
        Assertions.assertEquals(userDtos, result);
    }

    @Test
    void saveOneUser() {
    }

    @Test
    void updateOneUser() {
    }

    @Test
    void deleteOneUser() {
    }
}