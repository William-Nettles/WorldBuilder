package com.clquinn.services.setting;

import com.clquinn.daos.setting.WorldDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldService {

    private WorldDAO worldDAO;

    @Autowired
    public WorldService(WorldDAO worldDAO) {
        this.worldDAO = worldDAO;
    }

}
