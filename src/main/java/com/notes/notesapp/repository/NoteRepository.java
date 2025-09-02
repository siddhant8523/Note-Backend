package com.notes.notesapp.repository;

import com.notes.notesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}