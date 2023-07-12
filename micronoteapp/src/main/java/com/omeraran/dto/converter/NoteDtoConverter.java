package com.omeraran.dto.converter;

import com.omeraran.dto.NoteDto;
import com.omeraran.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteDtoConverter {
    private final NoteUserDtoConverter noteUserDtoConverter;

    public NoteDtoConverter(NoteUserDtoConverter noteUserDtoConverter) {
        this.noteUserDtoConverter = noteUserDtoConverter;
    }

    public NoteDto converter(Note from) {
        return new NoteDto(
                from.getId(),
                from.getContent(),
                noteUserDtoConverter.converter(from.getUser())
        );
    }

    public List<NoteDto> converter(List<Note> from) {
        return from.stream().map(x -> converter(x)).collect(Collectors.toList());
    }

    public Page<NoteDto> converter(Page<Note> notes) {
        List<NoteDto> noteDtos = converter(notes.getContent());
        return new PageImpl<>(noteDtos, notes.getPageable(), notes.getTotalElements());
    }
}
