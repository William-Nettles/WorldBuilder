package com.clquinn.controllers.setting;

import com.clquinn.models.setting.Map;
import com.clquinn.services.setting.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
public class MapController {

    private MapService mapService;

    @Autowired
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @PostMapping
    public ResponseEntity<Object> createMap(@RequestBody Map map) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(mapService.createMap(map));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getMaps() {
        try {
            return ResponseEntity.ok(mapService.getMaps());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMap(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(mapService.getMap(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getMapByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(mapService.getMapByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMap(@PathVariable Long id, @RequestBody Map map) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapService.updateMap(id, map));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMap(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mapService.deleteMap(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
        }
    }

}
