package com.clquinn.daos.character;

import com.clquinn.models.character.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceDAO extends JpaRepository<Race, Long> {
    Optional<Race> findByName(String raceName);
}
