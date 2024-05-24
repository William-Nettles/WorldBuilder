package com.clquinn.controllers.dictionary;

import com.clquinn.services.dictionary.AtlasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atlas")
public class AtlasController {

    private AtlasService atlasService;

    @Autowired
    public AtlasController(AtlasService atlasService) {
        this.atlasService = atlasService;
    }

}
