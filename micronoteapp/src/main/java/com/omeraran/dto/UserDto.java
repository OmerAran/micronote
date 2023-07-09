package com.omeraran.dto;

import java.util.Set;

public class UserDto {
    private Long id;
    private String username;
    private Set<UserNoteDto> notes;

    public UserDto(Long id, String username, Set<UserNoteDto> notes) {
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

    public Set<UserNoteDto> getNotes() {
        return notes;
    }

    public void setNotes(Set<UserNoteDto> notes) {
        this.notes = notes;
    }
}
