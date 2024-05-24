package com.clquinn.controllers.dictionary;

import com.clquinn.models.dictionary.atlas.Chart;
import com.clquinn.services.dictionary.AtlasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atlas")
public class AtlasController {

    private AtlasService atlasService;

    @Autowired
    public AtlasController(AtlasService atlasService) {
        this.atlasService = atlasService;
    }

    @PostMapping
    public ResponseEntity<Object> createAtlas(Chart chart) {
        try {
            return ResponseEntity.ok(atlasService.createAtlas(chart));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getCharts() {
        try {
            return ResponseEntity.ok(atlasService.getCharts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("location/{id}")
    public ResponseEntity<?> getChartsByLocation(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(atlasService.getChartsByLocation(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("map/{id}")
    public ResponseEntity<?> getChartsByMap(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(atlasService.getChartsByMap(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("location/{locationId}/map/{mapId}")
    public ResponseEntity<?> getChart(@PathVariable Long locationId, @PathVariable Long mapId) {
        try {
            return ResponseEntity.ok(atlasService.getChart(locationId, mapId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("location/{locationId}/map/{mapId}")
    public ResponseEntity<?> updateChart(@PathVariable Long locationId, @PathVariable Long mapId, @RequestBody Chart chart) {
        try {
            return ResponseEntity.ok(atlasService.updateChart(locationId, mapId, chart));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("location/{locationId}/map/{mapId}")
    public ResponseEntity<?> deleteChart(@PathVariable Long locationId, @PathVariable Long mapId) {
        try {
            return ResponseEntity.ok(atlasService.deleteChart(locationId, mapId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
