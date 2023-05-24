package com.hillel.springboot.web;

import com.hillel.springboot.dto.NoteDto;
import com.hillel.springboot.persistance.entity.Note;
import com.hillel.springboot.root.NoteService;
import com.hillel.springboot.web.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("note")
@RequiredArgsConstructor
public class NoteRestController {
    private final NoteMapper noteMapper;
    private final NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note insert(@RequestBody NoteDto dto) {
        Note note = noteMapper.map(dto);
        return noteService.create(note);
    }

    @GetMapping("/{id}")
    public NoteDto getById(@PathVariable Integer id) {
        Note note = noteService.findById(id).orElseThrow();
        return noteMapper.map(note);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        noteService.deleteById(id);
    }

    @GetMapping("/all")
    public List<Note> findALL() {
        return noteService.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody NoteDto noteDto) {
        Note note = noteService.findById(id).orElseThrow();
        noteService.update(note, noteMapper.map(noteDto));
    }

    @GetMapping("/searchDates")
    public List<NoteDto> searchByDates(@RequestParam(value = "start") Long start,
                                       @RequestParam(value = "end") Long end) {
        Date st = noteMapper.mapDate(start);
        Date en = noteMapper.mapDate(end);
        return noteService.searchByDate(st, en)
                .stream().map(noteMapper::map).toList();
    }

    @GetMapping("/search")
    public List<NoteDto> search(@RequestParam(value = "name") String name,
                                @RequestParam(value = "message") String message) {
        return noteService.search(name, message).stream().map(this.noteMapper::map).toList();
    }
}
