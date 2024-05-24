package com.clquinn.daos.character;

import com.clquinn.models.character.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceDAO extends JpaRepository<Integer, Race> {
}
