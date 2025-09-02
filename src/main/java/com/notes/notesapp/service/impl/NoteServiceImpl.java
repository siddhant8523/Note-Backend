package com.notes.notesapp.service.impl;

import com.notes.notesapp.exception.NoteNotFoundException;
import com.notes.notesapp.model.Note;
import com.notes.notesapp.repository.NoteRepository;
import com.notes.notesapp.service.NoteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        log.info("Creating note: {}", note.getTitle());
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Long id, Note note) {
        return noteRepository.findById(id)
                .map(existing -> {
                    log.info("Updating note with id {}", id);
                    existing.setTitle(note.getTitle());
                    existing.setContent(note.getContent());
                    return noteRepository.save(existing);
                })
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @Override
    public void deleteNote(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new NoteNotFoundException(id);
        }
        log.warn("Deleting note with id {}", id);
        noteRepository.deleteById(id);
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
