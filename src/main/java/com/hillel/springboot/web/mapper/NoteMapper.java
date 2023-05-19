package com.hillel.springboot.web;

import com.hillel.springboot.dto.NoteDto;
import com.hillel.springboot.persistance.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {
    public Note map(NoteDto noteDto) {
        return Note.builder()
                .name(noteDto.getName())
                .content(noteDto.getContent())
                .createdAt(noteDto.getCreatedAt())
                .build();
    }

    public NoteDto map(Note note) {
        return NoteDto.builder()
                .name(note.getName())
                .content(note.getContent())
                .createdAt(note.getCreatedAt())
                .build();
    }
}
