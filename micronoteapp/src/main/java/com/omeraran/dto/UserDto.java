package com.omeraran.dto;


import java.util.List;

public class UserDto {
    private Long id;
    private String username;
    private List<UserNoteDto> notes;

    public UserDto(Long id, String username, List<UserNoteDto> notes) {
        this.id = id;
        this.username = username;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserNoteDto> getNotes() {
        return notes;
    }

    public void setNotes(List<UserNoteDto> notes) {
        this.notes = notes;
    }
}
