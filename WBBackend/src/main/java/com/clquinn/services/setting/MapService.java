package com.clquinn.services.setting;

import com.clquinn.daos.setting.MapDAO;
import com.clquinn.models.setting.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    private final MapDAO mapDAO;

    @Autowired
    public MapService(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    public Map createMap(Map map) {
        if (map == null) {
            throw new RuntimeException("Map cannot be null");
        }
        if (map.getName() == null || map.getName().isEmpty()) {
            throw new RuntimeException("Map name cannot be null or empty");
        }
        if (mapDAO.findByName(map.getName()).isPresent()) {
            throw new RuntimeException("Map with name " + map.getName() + " already exists");
        }

        return mapDAO.save(map);
    }

    public List<Map> getMaps() {
        return mapDAO.findAll();
    }

    public Map getMap(Long id) {
        return mapDAO.findById(id).orElseThrow(() -> new RuntimeException("Map not found"));
    }

    public Map getMapByName(String name) {
        return mapDAO.findByName(name).orElseThrow(() -> new RuntimeException("Map not found"));
    }

    public Map updateMap(Long id, Map map) {
        if (mapDAO.existsById(id)) {
            return mapDAO.save(map);
        } else {
            throw new RuntimeException("Map not found");
        }
    }

    public String deleteMap(Long id) {
        if (mapDAO.existsById(id)) {
            mapDAO.deleteById(id);
            return "Map deleted";
        } else {
            throw new RuntimeException("Map not found");
        }
    }
}
