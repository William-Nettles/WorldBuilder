package com.clquinn.daos.dictionary;

import com.clquinn.models.dictionary.relationship.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelationshipDAO extends JpaRepository<Relationship,Long> {
    Optional<Relationship> findById_Character_IdAndId_TargetCharacter_Id(Long characterId, Long targetId);
}
