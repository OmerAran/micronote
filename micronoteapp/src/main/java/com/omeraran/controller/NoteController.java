package com.omeraran.controller;

import com.omeraran.dto.NoteDto;
import com.omeraran.dto.converter.NoteDtoConverter;
import com.omeraran.model.Note;
import com.omeraran.model.User;
import com.omeraran.repository.NoteRepository;
import com.omeraran.repository.UserRepository;
import com.omeraran.service.NoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/note")
public class NoteController {
   private final NoteRepository noteRepository;
   private final UserRepository userRepository;
   private final NoteDtoConverter noteDtoConverter;
   private final NoteService noteService;

    public NoteController(NoteRepository noteRepository, UserRepository userRepository, NoteDtoConverter noteDtoConverter, NoteService noteService) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.noteDtoConverter = noteDtoConverter;
        this.noteService = noteService;
    }
    @GetMapping("/{id}")
    public NoteDto getOneNote(@PathVariable Long id){
        NoteDto noteDto = noteService.getOneNote(id);
        return noteDto;
    }

    @PostMapping("/add")
    public NoteDto saveOneNote(@RequestBody Note note){
        NoteDto noteDto = noteService.saveOneNote(note);
        return noteDto;
    }

    @PutMapping("/edit")
    public NoteDto updateOneNote(@RequestBody Note note){
        NoteDto noteDto = noteService.updateOneNote(note);
        return noteDto;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOneNote(@PathVariable Long id){
        noteService.deleteOneNote(id);
    }
}
