package com.omeraran.dto.converter;

import com.omeraran.dto.UserNoteDto;
import com.omeraran.model.Note;
import org.springframework.stereotype.Component;

@Component
public class UserNoteDtoConverter {

    public UserNoteDto convert(Note from){
        return new UserNoteDto(
                from.getId(),
                from.getContent()
        );
    }
}
