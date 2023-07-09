package com.omeraran.dto.converter;

import com.omeraran.dto.NoteUserDto;
import com.omeraran.model.User;
import org.springframework.stereotype.Component;

@Component
public class NoteUserDtoConverter {

    public NoteUserDto converter(User from) {
        return new NoteUserDto(
                from.getId(),
                from.getUsername()
        );
    }
}
