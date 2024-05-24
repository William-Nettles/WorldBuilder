package com.clquinn.daos.dictionary;

import com.clquinn.models.dictionary.faction.FactionRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FactionRelationDAO extends JpaRepository<FactionRelation, Long> {
    Optional<FactionRelation> findById_Faction_IdAndId_Character_Id(Long id, Long character);

    List<FactionRelation> findById_Faction_Id(Long id);

    List<FactionRelation> findById_Character_Id(Long id);

    boolean existsById_Faction_IdAndId_Character_Id(Long factionId, Long characterId);

    void deleteById_Faction_IdAndId_Character_Id(Long factionId, Long characterId);
}
