package com.hillel.springboot.entity;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends ListCrudRepository<Note, Integer> {
   public Optional<Note> updateNoteByContent(String content);
}
