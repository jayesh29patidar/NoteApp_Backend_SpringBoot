package com.notesapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notesapp.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

	List<Note> findByUserId(Long userId);

}
