package com.notes.notesapp.controller;

import com.notes.notesapp.model.Note;
import com.notes.notesapp.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@Slf4j
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note) {
        log.info("Request to create note: {}", note.getTitle());
        return ResponseEntity.ok(noteService.createNote(note));
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        log.info("Request to fetch all notes");
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id) {
        log.info("Request to fetch note with id {}", id);
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable Long id, @RequestBody Note note) {
        log.info("Request to update note with id {}", id);
        return ResponseEntity.ok(noteService.updateNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Request to delete note with id {}", id);
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
