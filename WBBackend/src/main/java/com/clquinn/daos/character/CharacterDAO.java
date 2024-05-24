package com.clquinn.daos.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDAO extends JpaRepository<Integer, Character> {
}
