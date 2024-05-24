package com.clquinn.controllers.character;

import com.clquinn.services.character.FactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faction")
public class FactionController {

    private FactionService factionService;

    @Autowired
    public FactionController(FactionService factionService) {
        this.factionService = factionService;
    }
}
