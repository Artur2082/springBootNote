package com.hillel.springboot.root;

import com.hillel.springboot.persistance.entity.Note;
import com.hillel.springboot.persistance.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class NoteService {
    private NoteRepository noteRepository;

    public Note create(Note note) {
        return this.noteRepository.save(note);
    }

    public Optional<Note> findById(Integer id) {
        return this.noteRepository.findById(id);
    }

    public List<Note> findAll() {
        return this.noteRepository.findAll();
    }

    public void deleteById(Integer id) {
        this.noteRepository.deleteById(id);
    }

    public void update(Note note, Note newNote) {
        note.setName(newNote.getName());
        note.setContent(newNote.getContent());
        note.setCreatedAt(newNote.getCreatedAt());
        noteRepository.save(note);
    }

    public List<Note> searchByDate(Date start, Date end) {
        return noteRepository.findByCreatedAtBetweenOrderByCreatedAt(start, end);
    }

    public List<Note> search(String name, String message) {
        return this.noteRepository.findByNameContainingOrContentContaining(name, message);
    }
}
