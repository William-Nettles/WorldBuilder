package com.clquinn.services.dictionary;

import com.clquinn.daos.dictionary.AtlasDAO;
import com.clquinn.models.dictionary.atlas.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AtlasService {

    private AtlasDAO atlasDAO;

    @Autowired
    public AtlasService(AtlasDAO atlasDAO) {
        this.atlasDAO = atlasDAO;
    }

    public Chart createAtlas(Chart chart) {
        if (chart == null) {
            throw new RuntimeException("Chart cannot be null");
        }
        if (chart.getId() == null || chart.getId().getLocation()==null || chart.getId().getMap() == null) {
            throw new RuntimeException("Chart key cannot be null ");
        }
        if (atlasDAO.findById_Location_IdAndId_Map_Id(chart.getId().getLocation().getId(), chart.getId().getMap().getId()).isPresent()) {
            throw new RuntimeException("Chart with id " + chart.getId().getLocation().getId() + chart.getId().getMap().getId() + " already exists");
        }

        return atlasDAO.save(chart);
    }

    public List<Chart> getCharts() { return atlasDAO.findAll(); }


    public List<Chart> getChartsByLocation(Long id) {
        return atlasDAO.findById_Location_Id(id);
    }

    public List<Chart> getChartsByMap(Long id) {
        return atlasDAO.findById_Map_Id(id);
    }

    public Object getChart(Long locationId, Long mapId) {
        return atlasDAO.findById_Location_IdAndId_Map_Id(locationId, mapId).orElseThrow(() -> new RuntimeException("Chart not found"));
    }

    public Object updateChart(Long locationId, Long mapId, Chart chart) {
        if (atlasDAO.existsById_Location_IdAndId_Map_Id(locationId, mapId)) {
            return atlasDAO.save(chart);
        } else {
            throw new RuntimeException("Chart not found");
        }
    }

    public Object deleteChart(Long locationId, Long mapId) {
        if (atlasDAO.existsById_Location_IdAndId_Map_Id(locationId, mapId)) {
            atlasDAO.deleteById_Location_IdAndId_Map_Id(locationId, mapId);
            return "Chart deleted";
        } else {
            throw new RuntimeException("Chart not found");
        }
    }
}
