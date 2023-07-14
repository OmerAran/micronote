package com.omeraran.dto;

public class NoteDto {
    private Long id;
    private String content;
    private NoteUserDto user;

    public NoteDto(Long id, String content, NoteUserDto user) {
        this.id = id;
        this.content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NoteUserDto getUser() {
        return user;
    }

    public void setUser(NoteUserDto user) {
        this.user = user;
    }
}
