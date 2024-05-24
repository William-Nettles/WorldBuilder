package com.clquinn.controllers.character;

import com.clquinn.models.character.Race;
import com.clquinn.services.character.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/race")
public class RaceController {

    private RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping
    public ResponseEntity<?> createRace(@RequestBody Race race) {
        try {
            return ResponseEntity.ok(raceService.createRace(race));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getRaces() {
        try {
            return ResponseEntity.ok(raceService.getRaces());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRace(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(raceService.getRace(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRace(@PathVariable Long id, @RequestBody Race race) {
        try {
            return ResponseEntity.ok(raceService.updateRace(race));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRace(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(raceService.deleteRace(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
