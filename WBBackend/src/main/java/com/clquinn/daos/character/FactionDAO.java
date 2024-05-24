package com.clquinn.daos.character;

import com.clquinn.models.character.Faction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionDAO extends JpaRepository<Integer, Faction>{
}
