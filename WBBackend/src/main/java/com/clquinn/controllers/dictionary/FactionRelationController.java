package com.clquinn.controllers.dictionary;

import com.clquinn.services.dictionary.FactionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factionrelation")
public class FactionRelationController {

    private FactionRelationService factionRelationService;

    @Autowired
    public FactionRelationController(FactionRelationService factionRelationService) {
        this.factionRelationService = factionRelationService;
    }

}
