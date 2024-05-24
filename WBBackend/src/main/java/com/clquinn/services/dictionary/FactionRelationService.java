package com.clquinn.services.dictionary;

import com.clquinn.daos.dictionary.FactionRelationDAO;
import com.clquinn.models.dictionary.faction.FactionRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactionRelationService {

    private final FactionRelationDAO factionRelationDAO;

    @Autowired
    public FactionRelationService(FactionRelationDAO factionRelationDAO) {
        this.factionRelationDAO = factionRelationDAO;
    }

    public FactionRelation createFactionRelation(FactionRelation factionRelation) {
        if (factionRelation == null) {
            throw new RuntimeException("FactionRelation cannot be null");
        }
        if (factionRelation.getId().getFaction() == null || factionRelation.getId().getCharacter() == null) {
            throw new RuntimeException("FactionRelation cannot be null");
        }
        if (factionRelationDAO.findById_Faction_IdAndId_Character_Id(factionRelation.getId().getFaction().getId(), factionRelation.getId().getCharacter().getId()).isPresent()) {
            throw new RuntimeException("FactionRelation with factions " + factionRelation.getId().getFaction().getName() + " and " + factionRelation.getId().getCharacter().getFirstName() + " already exists");
        }

        return factionRelationDAO.save(factionRelation);
    }

    public List<FactionRelation> getFactionRelations() {
        return factionRelationDAO.findAll();
    }

    public List<FactionRelation> getFactionRelationsByFaction(Long id) {
        return factionRelationDAO.findById_Faction_Id(id);
    }

    public List<FactionRelation> getFactionRelationsByCharacter(Long id) {
        return factionRelationDAO.findById_Character_Id(id);
    }

    public FactionRelation getFactionRelationByFactionAndCharacter(Long factionId, Long characterId) {
        return factionRelationDAO.findById_Faction_IdAndId_Character_Id(factionId, characterId).orElseThrow(() -> new RuntimeException("FactionRelation not found")); }

    public FactionRelation updateFactionRelation(Long factionId, Long characterId, FactionRelation factionRelation) {
        if (factionRelationDAO.existsById_Faction_IdAndId_Character_Id(factionId, characterId)) {
            return factionRelationDAO.save(factionRelation);
        } else {
            throw new RuntimeException("FactionRelation not found");
        }
    }

    public String deleteFactionRelation(Long factionId, Long characterId) {
        if (factionRelationDAO.existsById_Faction_IdAndId_Character_Id(factionId, characterId)) {
            factionRelationDAO.deleteById_Faction_IdAndId_Character_Id(factionId, characterId);
            return "FactionRelation deleted";
        } else {
            throw new RuntimeException("FactionRelation not found");
        }
    }
}
