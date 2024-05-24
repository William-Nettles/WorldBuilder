package com.clquinn.controllers.dictionary;

import com.clquinn.models.dictionary.faction.FactionRelation;
import com.clquinn.services.dictionary.FactionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factionrelation")
public class FactionRelationController {

    private FactionRelationService factionRelationService;

   @Autowired
    public FactionRelationController(FactionRelationService factionRelationService) {
        this.factionRelationService = factionRelationService;
    }

    @PostMapping
    public ResponseEntity<Object> createFactionRelation(FactionRelation factionRelation) {
        try {
            return ResponseEntity.ok(factionRelationService.createFactionRelation(factionRelation));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getFactionRelations() {
        try {
            return ResponseEntity.ok(factionRelationService.getFactionRelations());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getFactionRelationsByFaction(Long id) {
        try {
            return ResponseEntity.ok(factionRelationService.getFactionRelationsByFaction(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getFactionRelationsByCharacter(Long id) {
        try {
            return ResponseEntity.ok(factionRelationService.getFactionRelationsByCharacter(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getFactionRelationByFactionAndCharacter(Long factionId, Long characterId) {
        try {
            return ResponseEntity.ok(factionRelationService.getFactionRelationByFactionAndCharacter(factionId, characterId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateFactionRelation(Long factionId, Long characterId, FactionRelation factionRelation) {
        try {
            return ResponseEntity.ok(factionRelationService.updateFactionRelation(factionId, characterId, factionRelation));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   @DeleteMapping
    public ResponseEntity<Object> deleteFactionRelation(Long factionId, Long characterId) {
        try {
            return ResponseEntity.ok(factionRelationService.deleteFactionRelation(factionId, characterId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
