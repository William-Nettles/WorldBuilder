package com.clquinn.daos.character;

import com.clquinn.models.character.Subrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubraceDAO extends JpaRepository<Subrace, Long>{

    Optional<Object> findByName(String name);
}
