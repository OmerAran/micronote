package com.omeraran.service;


import com.omeraran.dto.NoteDto;
import com.omeraran.dto.converter.NoteDtoConverter;
import com.omeraran.model.Note;
import com.omeraran.repository.NoteRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteDtoConverter noteDtoConverter;

    public NoteService(NoteRepository noteRepository, NoteDtoConverter noteDtoConverter) {
        this.noteRepository = noteRepository;
        this.noteDtoConverter = noteDtoConverter;
    }

    public List<NoteDto> getAllNotes(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Note> notes = noteRepository.findAll(paging);
        return noteDtoConverter.converter(notes.getContent());
    }

    public NoteDto getOneNote(Long id) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found with id : " + id));
        return noteDtoConverter.converter(note);
    }

    public NoteDto saveOneNote(Note note) {
        Note savedNote = noteRepository.save(note);
        return noteDtoConverter.converter(savedNote);
    }

    public NoteDto updateOneNote(Note updatedNote) {
        Note note = noteRepository.findById(updatedNote.getId()).orElseThrow(() ->
                    new RuntimeException("not found with id: " + updatedNote.getId()));
        note.setContent(updatedNote.getContent());
        return noteDtoConverter.converter(
                noteRepository.save(note));
    }

    public void deleteOneNote(Long id) {
        noteRepository.deleteById(id);
    }

}
