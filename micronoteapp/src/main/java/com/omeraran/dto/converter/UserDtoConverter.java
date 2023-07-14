package com.omeraran.dto.converter;

import com.omeraran.dto.UserDto;
import com.omeraran.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public List<UserDto> converter(List<User> from) {
        return from
                .stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }

    public Page<UserDto> converter(Page<User> from) {
        List<UserDto> userDtos = converter(from.getContent());
        return new PageImpl<>(userDtos, from.getPageable(), from.getTotalElements());
    }
}
