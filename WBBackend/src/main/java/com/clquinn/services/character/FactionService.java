package com.clquinn.services.character;

import com.clquinn.daos.character.FactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactionService {

    private FactionDAO factionDAO;

    @Autowired
    public FactionService(FactionDAO factionDAO) {
        this.factionDAO = factionDAO;
    }

}
