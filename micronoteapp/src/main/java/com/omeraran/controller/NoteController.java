package com.omeraran.controller;

import com.omeraran.dto.NoteDto;
import com.omeraran.model.Note;
import com.omeraran.service.NoteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public ResponseEntity<List<NoteDto>> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNo,
                                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        List<NoteDto> notes = noteService.getAllNotes(pageNo, pageSize);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDto> getOneNote(@PathVariable Long id) {
        NoteDto noteDto = noteService.getOneNote(id);
        return new ResponseEntity<>(noteDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<NoteDto> saveOneNote(@RequestBody Note note) {
        NoteDto noteDto = noteService.saveOneNote(note);
        return new ResponseEntity<>(noteDto, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<NoteDto> updateOneNote(@RequestBody Note note) {
        NoteDto noteDto = noteService.updateOneNote(note);
        return new ResponseEntity<>(noteDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneNote(@PathVariable Long id) {
        noteService.deleteOneNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
