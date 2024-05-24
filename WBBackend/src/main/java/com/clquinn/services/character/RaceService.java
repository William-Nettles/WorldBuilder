package com.clquinn.services.character;

import com.clquinn.daos.character.RaceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    private RaceDAO raceDAO;

    @Autowired
    public RaceService(RaceDAO raceDAO) {
        this.raceDAO = raceDAO;
    }
}
