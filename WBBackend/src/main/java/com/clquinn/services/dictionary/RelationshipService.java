package com.clquinn.services.dictionary;

import com.clquinn.daos.dictionary.RelationshipDAO;
import com.clquinn.models.dictionary.relationship.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationshipService {

    private RelationshipDAO relationshipDAO;

    @Autowired
    public RelationshipService(RelationshipDAO relationshipDAO) {
        this.relationshipDAO = relationshipDAO;
    }

    public  Relationship createRelationship(Relationship relationship) {
        return relationshipDAO.save(relationship);
    }

    public Relationship getRelationship(Long id) {
        Optional<Relationship> relationship = relationshipDAO.findById(id);
        if (relationship.isPresent()) {
            return relationship.get();
        } else {
            throw new RuntimeException("Relationship not found");
        }
    }

    public List<Relationship> getAllRelationships() {
        return relationshipDAO.findAll();
    }

    public Relationship getRelationshipByCharacters(Long characterId, Long targetId) {
        Optional<Relationship> relationship = relationshipDAO.findById_Character_IdAndId_TargetCharacter_Id(characterId, targetId);
        if (relationship.isPresent()) {
            return relationship.get();
        } else {
            throw new RuntimeException("Relationship not found");
        }
    }

    public Relationship updateRelationship( Relationship relationship) {
        Optional<Relationship> relationshipOptional = relationshipDAO.findById_Character_IdAndId_TargetCharacter_Id(relationship.getId().getCharacter().getId(), relationship.getId().getTargetCharacter().getId());
        if (relationshipOptional.isPresent()) {
            Relationship relationshipToUpdate = relationshipOptional.get();
            relationshipToUpdate.setRelationship(relationship.getRelationship());
            return relationshipDAO.save(relationshipToUpdate);
        } else {
            throw new RuntimeException("Relationship not found");
        }
    }

    public void deleteRelationship(Long id, Long targetId) {
        Optional<Relationship> relationship = relationshipDAO.findById_Character_IdAndId_TargetCharacter_Id(id, targetId);
        if (relationship.isPresent()) {
            relationshipDAO.delete(relationship.get());
        } else {
            throw new RuntimeException("Relationship not found");
        }
    }
}
