package com.omeraran.dto.converter;

import com.omeraran.dto.NoteDto;
import com.omeraran.model.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteDtoConverter {
    private final UserDtoConverter userDtoConverter;

    public NoteDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }

    public NoteDto converter(Note from){
        return new NoteDto(
                from.getId(),
                from.getContent(),
                userDtoConverter.converter(from.getUser())
        );
    }
}
