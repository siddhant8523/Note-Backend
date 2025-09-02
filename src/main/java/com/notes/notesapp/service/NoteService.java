package com.notes.notesapp.service;

import com.notes.notesapp.model.Note;

import java.util.List;

public interface NoteService {
    Note createNote(Note note);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);

    Note getNoteById(Long id);
    
    List<Note> getAllNotes();
}
