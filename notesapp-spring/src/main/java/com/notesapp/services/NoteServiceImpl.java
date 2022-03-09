package com.notesapp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.notesapp.exception.ResourceNotFoundException;
import com.notesapp.model.Note;
import com.notesapp.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	@Override
	public Note createNote(Note note) {

		return noteRepository.save(note);
	}

	@Override
	public ResponseEntity<Note> getNoteById(Long id) {
		Note note = noteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Note not exist with id:" + id));

		return ResponseEntity.ok(note);
	}

	@Override
	public ResponseEntity<Note> updateNote(Long id, Note noteDetails) {
		// TODO Auto-generated method stub
		Note note = noteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Note not exitst with id:" + id));

		note.setName(noteDetails.getName());
		note.setContent(noteDetails.getContent());

		Note updatNote = noteRepository.save(note);
		return ResponseEntity.ok(updatNote);
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteNote(Long id) {

		Note note = noteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Note not exitst with id:" + id));
		noteRepository.delete(note);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@Override
	public List<Note> getAllNotesByUser(long id) {
		// TODO Auto-generated method stub
		return noteRepository.findByUserId(id);
	}

}
