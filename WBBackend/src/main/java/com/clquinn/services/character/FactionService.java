package com.clquinn.services.character;

import com.clquinn.daos.character.FactionDAO;
import com.clquinn.models.character.Faction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FactionService {

    private FactionDAO factionDAO;

    @Autowired
    public FactionService(FactionDAO factionDAO) {
        this.factionDAO = factionDAO;
    }

    public Object createFaction(Faction faction) {
        if (faction == null) {
            return "Faction cannot be null";
        }

        if (faction.getName() == null || faction.getName().isEmpty()) {
            return "Faction name cannot be null or empty";
        }

        if (factionDAO.findByName(faction.getName()).isPresent()) {
            return "Faction with name " + faction.getName() + " already exists";
        }

        return factionDAO.save(faction);
    }

    public Object getFactions() {
        return factionDAO.findAll();
    }

    public Object getFaction(Long id) {
        Optional<Faction> faction = factionDAO.findById(id);
        if (faction.isPresent()) {
            return faction.get();
        } else {
            return "Faction with id " + id + " not found";
        }
    }

    public Object getFactionByName(String name) {
        Optional<Faction> faction = factionDAO.findByName(name);
        if (faction.isPresent()) {
            return faction.get();
        } else {
            return "Faction with name " + name + " not found";
        }
    }

    public Object updateFaction(Long id, Faction faction) {
        Optional<Faction> optionalFaction = factionDAO.findById(id);
        if (optionalFaction.isPresent()) {
            Faction existingFaction = optionalFaction.get();
            existingFaction.setName(faction.getName());
            existingFaction.setDescription(faction.getDescription());
            return factionDAO.save(existingFaction);
        } else {
            return "Faction with id " + id + " not found";
        }
    }

    public Object deleteFaction(Long id) {
        if (factionDAO.existsById(id)) {
            factionDAO.deleteById(id);
            return "Faction with id " + id + " deleted";
        } else {
            return "Faction with id " + id + " not found";
        }
    }
}
