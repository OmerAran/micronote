package com.omeraran.controller;

import com.omeraran.dto.NoteDto;
import com.omeraran.model.Note;
import com.omeraran.service.NoteService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("api/v1/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public List<NoteDto> getAllUsers() {
        List<NoteDto> notes = noteService.getAllNotes();
        return notes;
    }

    @GetMapping("/{id}")
    public NoteDto getOneNote(@PathVariable Long id) {
        NoteDto noteDto = noteService.getOneNote(id);
        return noteDto;
    }

    @PostMapping("/add")
    public NoteDto saveOneNote(@RequestBody Note note) {
        NoteDto noteDto = noteService.saveOneNote(note);
        return noteDto;
    }

    @PutMapping("/edit")
    public NoteDto updateOneNote(@RequestBody Note note) {
        NoteDto noteDto = noteService.updateOneNote(note);
        return noteDto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneNote(@PathVariable Long id) {
        noteService.deleteOneNote(id);
    }
}
