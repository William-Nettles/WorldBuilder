package com.clquinn.daos;

import com.clquinn.models.dictionary.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDAO extends JpaRepository<Note, Long> {

    List<Note> findByWorldIdAndPin(Long worldId, String pin);

    List<Note> findByWorldId(Long worldId);
}
