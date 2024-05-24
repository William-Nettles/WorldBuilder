package com.clquinn.daos.character;

import com.clquinn.models.character.Faction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactionDAO extends JpaRepository<Faction, Long>{
    Optional<Faction> findByName(String name);
}
