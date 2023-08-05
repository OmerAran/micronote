package com.omeraran.service;

import com.omeraran.dto.NoteDto;
import com.omeraran.dto.NoteUserDto;
import com.omeraran.dto.converter.NoteDtoConverter;
import com.omeraran.model.Note;
import com.omeraran.repository.NoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

class NoteServiceTest {

    private NoteRepository noteRepository;
    private NoteDtoConverter noteDtoConverter;
    private NoteService noteService;

    @BeforeEach
    void setUp() {
        noteRepository = Mockito.mock(NoteRepository.class);
        noteDtoConverter = Mockito.mock(NoteDtoConverter.class);
        noteService = new NoteService(noteRepository, noteDtoConverter);
    }

    @Test
    void shouldReturnListOfNoteDtos_whenRequestIsGetAllNotes() {
        //given
        int pageSize=10;
        int pageNo=0;

        NoteUserDto noteUserDto = new NoteUserDto(1L,"omer");

        NoteDto noteDto = new NoteDto(1L, "co",noteUserDto);
        NoteDto noteDto2 = new NoteDto(2L, "nt",noteUserDto);
        NoteDto noteDto3 = new NoteDto(3L, "ent",noteUserDto);

        Note note = new Note(1L,"co");
        Note note2 = new Note(2L,"nt");
        Note note3 = new Note(3L,"ent");

        List<Note> notes = List.of(new Note[]{note, note2, note3});
        Page<Note> page = new PageImpl<>(notes);
        List<NoteDto> noteDtos = List.of(new NoteDto[]{noteDto, noteDto2, noteDto3});
        Pageable paging = PageRequest.of(pageNo, pageSize);
        //when
        Mockito.when(noteRepository.findAll(paging)).thenReturn((page));
        Mockito.when(noteDtoConverter.converter(notes)).thenReturn(noteDtos);
        List<NoteDto> result = noteService.getAllNotes(pageNo, pageSize);
        //then
        Assertions.assertEquals(noteDtos, result);
    }

    @Test
    void itShouldReturnOneNoteDtoById_whenRequestIsGetOneById() {
        Long id = 1L;
        NoteUserDto noteUserDto = new NoteUserDto(id,"omer");
        Note note = new Note(id,"CONTENT");
        NoteDto noteDto = new NoteDto(id,"CONTENT", noteUserDto);

        Mockito.when(noteRepository.findById(id)).thenReturn(Optional.of(note));
        Mockito.when(noteDtoConverter.converter(note)).thenReturn(noteDto);

        NoteDto result = noteService.getOneNote(id);
        Assertions.assertEquals(noteDto, result);
    }

    @Test
    void saveOneNote() {
        Long id = 1L;
        NoteUserDto noteUserDto = new NoteUserDto(id,"omer");
        Note note = new Note(id, "C");
        NoteDto noteDto = new NoteDto(id, "C", noteUserDto);
        NoteDto expected = noteDto;

        Mockito.when(noteRepository.save(note)).thenReturn(note);
        Mockito.when(noteDtoConverter.converter(note)).thenReturn(noteDto);
        NoteDto result = noteService.saveOneNote(note);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void updateOneNote() {
        Long id = 1L;
        NoteUserDto noteUserDto = new NoteUserDto(id, "omer");
        Note note = new Note(id, "c");
        NoteDto noteDto = new NoteDto(id, "c", noteUserDto);
        NoteDto newNoteDto = new NoteDto(id, "x", noteUserDto);
        Note newNote = new Note(id,"x");

        Mockito.when(noteRepository.findById(note.getId())).thenReturn(Optional.of(newNote));
        Mockito.when(noteRepository.save(newNote)).thenReturn(newNote);
        Mockito.when(noteDtoConverter.converter(newNote)).thenReturn(newNoteDto);

        NoteDto result = noteService.updateOneNote(note);
        Assertions.assertEquals(newNoteDto, result);
    }

    @Test
    void deleteOneNote() {
        Long id =1L;
        Note note = new Note(id, "CONTEXT");

        Mockito.when(noteRepository.findById(id)).thenReturn(Optional.of(note));
        noteService.deleteOneNote(id);
        Assertions.assertNull(noteService.getOneNote(id));
    }
}