package com.omeraran.dto;

import com.omeraran.model.ERole;

import java.util.Set;

public class UserDto {
    private Long id;
    private String username;
    private ERole role;
    private Set<UserNoteDto> notes;

    public UserDto(Long id, String username, ERole role, Set<UserNoteDto> notes) {
        this.id = id;
        this.username = username;
        this.role = role;
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

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public Set<UserNoteDto> getNotes() {
        return notes;
    }

    public void setNotes(Set<UserNoteDto> notes) {
        this.notes = notes;
    }
}
