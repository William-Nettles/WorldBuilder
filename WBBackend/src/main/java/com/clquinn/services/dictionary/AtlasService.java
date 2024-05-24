package com.clquinn.services.dictionary;

import com.clquinn.daos.dictionary.AtlasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtlasService {

    private AtlasDAO atlasDAO;

    @Autowired
    public AtlasService(AtlasDAO atlasDAO) {
        this.atlasDAO = atlasDAO;
    }

}
