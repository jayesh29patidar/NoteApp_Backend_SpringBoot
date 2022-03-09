package com.notesapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notesapp.model.Note;
import com.notesapp.model.User;
import com.notesapp.services.NoteService;

@RestController
@RequestMapping("/api/v1")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@GetMapping("/welcome")
	public String note() {
		return "this is notes welcome page, I have sending this from spring boot.";
	}

	// get all notes
	@GetMapping("/notes")
	public List<Note> getAllNotes() {
		return noteService.getAllNotes();
	}

	// Create add Notes
	@PostMapping("/notes")
	public Note createNote(@RequestBody Note note) {
		return noteService.createNote(note);
	}
	
	//get Note with Id
	@GetMapping("/notes/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable Long id){
		return noteService.getNoteById(id);
	}
	
	//update notes
	@PutMapping("/notes/{id}")
	public ResponseEntity<Note> updateNotes(@PathVariable Long id, @RequestBody Note noteDetails){
		return noteService.updateNote(id, noteDetails);
	}
	
	//delete note
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteNote(@PathVariable Long id){
		return noteService.deleteNote(id);
	}
	
	//get all note by user->id
	@PostMapping("/notes/get-all")
	public List<Note> getAllNotesByUser(@RequestBody User user) {
		System.out.println(user.toString());
		return noteService.getAllNotesByUser(user.getId());
	}
	
}
