package com.clquinn.controllers;

import com.clquinn.models.dictionary.Note;
import com.clquinn.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:3000")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Object> createNote(@RequestBody Note note) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(note));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getNotes() {
        try {
            return ResponseEntity.ok(noteService.getAllNotes());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(noteService.getNoteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/world/{worldId}/pin/{pin}")
    public ResponseEntity<?> getNotesByWorldIdAndPin(@PathVariable Long worldId, @PathVariable String pin) {
        try {
            return ResponseEntity.ok(noteService.getNotesByWorldIdAndPin(worldId, pin));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/world/{worldId}")
    public ResponseEntity<?> getNotesByWorldId(@PathVariable Long worldId) {
        try {
            return ResponseEntity.ok(noteService.getNotesByWorldId(worldId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNoteById(@PathVariable Long id, @RequestBody Note note) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(noteService.updateNoteById(id, note));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNoteById(@PathVariable Long id) {
        try {
            noteService.deleteNoteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Note deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
        }
    }
}
