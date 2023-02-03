package com.omeraran.controller;

import com.omeraran.dto.NoteDto;
import com.omeraran.dto.converter.NoteDtoConverter;
import com.omeraran.model.Note;
import com.omeraran.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/note")
public class NoteController {
   private final NoteRepository noteRepository;
   private final NoteDtoConverter noteDtoConverter;

    public NoteController(NoteRepository noteRepository, NoteDtoConverter noteDtoConverter) {
        this.noteRepository = noteRepository;
        this.noteDtoConverter = noteDtoConverter;
    }

    @GetMapping("/{id}")
    public NoteDto getOneNote(@PathVariable Long id){
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException());
        NoteDto noteDto = noteDtoConverter.converter(note);
        return noteDto;
    }

    @PostMapping("/add")
    public Note saveOneNote(@RequestBody Note note){
        return noteRepository.save(note);
    }
}
