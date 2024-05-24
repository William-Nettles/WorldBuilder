package com.clquinn.services.character;

import com.clquinn.daos.character.RaceDAO;
import com.clquinn.models.character.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    private RaceDAO raceDAO;

    @Autowired
    public RaceService(RaceDAO raceDAO) {
        this.raceDAO = raceDAO;
    }

    public Object createRace(Race race) {
        if(race == null) {
            throw new IllegalArgumentException("race cannot be null");
        }
        if (race.getName().isBlank()) {
            throw new IllegalArgumentException("race name cannot be blank");
        }
        return raceDAO.save(race);
    }

    public Object getRaces() {
        return raceDAO.findAll();
    }

    public Object getRace(Long id) {
        return raceDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("cannot find race"));
    }

    public Object updateRace(Race race) {
        Race existingRace = raceDAO.findById(race.getId()).orElseThrow(() -> new IllegalArgumentException("cannot find race"));
        existingRace.setName(race.getName());
        existingRace.setDescription(race.getDescription());
        existingRace.setImage(race.getImage());
        return raceDAO.save(existingRace);
    }

    public Object deleteRace(Long id) {
        if (raceDAO.existsById(id)) {
            raceDAO.deleteById(id);
            return "successfully deleted";
        } else {
            throw new IllegalArgumentException("cannot find race");
        }
    }
}
