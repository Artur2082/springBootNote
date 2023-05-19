package com.hillel.springboot.persistance.repository;

import com.hillel.springboot.persistance.entity.Note;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface NoteRepository extends ListCrudRepository<Note, Integer> {
    List<Note> findByNameOrContentContaining(String name, String message);

    List<Note> findByCreatedAtBetweenOrderByCreatedAt(Date start, Date end);
}
