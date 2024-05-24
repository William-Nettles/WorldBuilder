package com.clquinn.services.setting;

import com.clquinn.daos.setting.MapDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {

    private MapDAO mapDAO;

    @Autowired
    public MapService(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }
}
