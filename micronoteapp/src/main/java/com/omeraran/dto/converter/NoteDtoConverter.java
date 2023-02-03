package com.omeraran.dto.converter;

import com.omeraran.dto.NoteDto;
import com.omeraran.model.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteDtoConverter {
    private final NoteUserDtoConverter noteUserDtoConverter;

    public NoteDtoConverter(NoteUserDtoConverter noteUserDtoConverter) {
        this.noteUserDtoConverter = noteUserDtoConverter;
    }

    public NoteDto converter(Note from){
        return new NoteDto(
                from.getId(),
                from.getContent(),
                noteUserDtoConverter.converter(from.getUser())
        );
    }
}
