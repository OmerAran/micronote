package com.omeraran.dto.converter;

import com.omeraran.dto.UserDto;
import com.omeraran.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
    private final UserNoteDtoConverter userNoteDtoConverter;

    public UserDtoConverter(UserNoteDtoConverter userNoteDtoConverter) {
        this.userNoteDtoConverter = userNoteDtoConverter;
    }

    public UserDto converter(User from) {
        return new UserDto(
                from.getId(),
                from.getUsername(),
                from.getRole(),
                from.getNotes()
                        .stream()
                        .map(userNoteDtoConverter::convert)
                        .collect(Collectors.toSet())

        );

    }
}
