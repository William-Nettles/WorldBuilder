package com.clquinn.services.dictionary;

import com.clquinn.daos.dictionary.FactionRelationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactionRelationService {

    private FactionRelationDAO factionRelationDAO;

    @Autowired
    public FactionRelationService(FactionRelationDAO factionRelationDAO) {
        this.factionRelationDAO = factionRelationDAO;
    }

}
