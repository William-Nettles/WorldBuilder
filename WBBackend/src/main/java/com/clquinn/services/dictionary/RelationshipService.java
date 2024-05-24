package com.clquinn.services.dictionary;

import com.clquinn.daos.dictionary.RelationshipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService {

    private RelationshipDAO relationshipDAO;

    @Autowired
    public RelationshipService(RelationshipDAO relationshipDAO) {
        this.relationshipDAO = relationshipDAO;
    }

}
