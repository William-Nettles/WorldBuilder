package com.clquinn.services;

import com.clquinn.daos.NoteDAO;
import com.clquinn.models.dictionary.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteDAO noteDAO;

    @Autowired
    public NoteService(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    public Note createNote(Note note) {
        return noteDAO.save(note);
    }

    public Note getNoteById(Long id) {
        return noteDAO.findById(id).orElse(null);
    }

    public Note updateNoteById(Long id, Note note) {
        Note existingNote = noteDAO.findById(id).orElse(null);
        if (existingNote == null) {
            return null;
        }
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        existingNote.setType(note.getType());
        existingNote.setDate(note.getDate());
        existingNote.setPin(note.getPin());
        return noteDAO.save(existingNote);
    }

    public boolean deleteNoteById(Long id) {
        Note existingNote = noteDAO.findById(id).orElse(null);
        if (existingNote == null) {
            return false;
        }
        noteDAO.delete(existingNote);
        return true;
    }

    public List<Note> getAllNotes() {
        return noteDAO.findAll();
    }

    public List<Note> getNotesByWorldIdAndPin(Long worldId, String pin) {
        return noteDAO.findByWorldIdAndPin(worldId, pin);
    }

    public List<Note> getNotesByWorldId(Long worldId) {
        return noteDAO.findByWorldId(worldId);
    }

}
