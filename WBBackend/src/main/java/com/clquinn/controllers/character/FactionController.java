package com.clquinn.controllers.character;

import com.clquinn.models.character.Faction;
import com.clquinn.services.character.FactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faction")
public class FactionController {

    private FactionService factionService;

    @Autowired
    public FactionController(FactionService factionService) {
        this.factionService = factionService;
    }

    @PostMapping
    public ResponseEntity<?> createFaction(@RequestBody Faction faction) {
        try {
            return ResponseEntity.ok(factionService.createFaction(faction));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getFactions() {
        try {
            return ResponseEntity.ok(factionService.getFactions());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFaction(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(factionService.getFaction(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getFactionByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(factionService.getFactionByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFaction(@PathVariable Long id, @RequestBody Faction faction) {
        try {
            return ResponseEntity.ok(factionService.updateFaction(id, faction));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFaction(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(factionService.deleteFaction(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
