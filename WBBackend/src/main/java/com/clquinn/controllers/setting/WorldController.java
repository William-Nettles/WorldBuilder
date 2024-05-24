package com.clquinn.controllers.setting;

import com.clquinn.services.setting.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/world")
public class WorldController {

    private WorldService worldService;

    @Autowired
    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

}
