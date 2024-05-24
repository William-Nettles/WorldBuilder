package com.clquinn.controllers.character;

import com.clquinn.services.character.SubraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subrace")
public class SubraceController {

    private SubraceService subraceService;

    @Autowired
    public SubraceController(SubraceService subraceService) {
        this.subraceService = subraceService;
    }
}
