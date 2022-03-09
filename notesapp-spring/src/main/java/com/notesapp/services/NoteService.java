package com.notesapp.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.notesapp.model.Note;

public interface NoteService {

	public List<Note> getAllNotes();

	public Note createNote(@RequestBody Note note);

	public ResponseEntity<Note> getNoteById(@PathVariable Long id);

	public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteDetails);

	public ResponseEntity<Map<String, Boolean>> deleteNote(@PathVariable Long id);

	public List<Note> getAllNotesByUser(@PathVariable long id);
}
