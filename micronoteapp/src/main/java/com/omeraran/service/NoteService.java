package com.omeraran.service;


import com.omeraran.dto.NoteDto;
import com.omeraran.dto.converter.NoteDtoConverter;
import com.omeraran.model.Note;
import com.omeraran.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteDtoConverter noteDtoConverter;

    public NoteService(NoteRepository noteRepository, NoteDtoConverter noteDtoConverter) {
        this.noteRepository = noteRepository;
        this.noteDtoConverter = noteDtoConverter;
    }

    public NoteDto getOneNote(Long id){
       Note note = noteRepository.findById(id).orElseThrow(()->new RuntimeException("Note not found with id : " + id));
       NoteDto noteDto = noteDtoConverter.converter(note);
       return noteDto;
    }

    public NoteDto saveOneNote(Note note){
        Note savedNote = noteRepository.save(note);
        NoteDto noteDto = noteDtoConverter.converter(savedNote);
        return noteDto;
    }

    public NoteDto updateOneNote(Note updatedNote){
        Note note = noteRepository.findById(updatedNote.getId()).orElseThrow(()->
                new RuntimeException("not found with id: " + updatedNote.getId()));
        note.setContent(updatedNote.getContent());
        NoteDto noteDto = noteDtoConverter.converter(noteRepository.save(note));
        return noteDto;
    }

    public void deleteOneNote(Long id){
        noteRepository.deleteById(id);
    }
}
