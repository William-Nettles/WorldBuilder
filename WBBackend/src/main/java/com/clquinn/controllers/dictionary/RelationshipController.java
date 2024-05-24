package com.clquinn.controllers.dictionary;

import com.clquinn.models.dictionary.relationship.Relationship;
import com.clquinn.services.dictionary.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {

    private RelationshipService relationshipService;

    @Autowired
    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

   @PostMapping
    public ResponseEntity<Object> createRelationship(@RequestBody Relationship relationship) {
        try {
            relationshipService.createRelationship(relationship);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Relationship not created: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Relationship created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRelationship(@PathVariable Long id) {
        try {
            Relationship relationship = relationshipService.getRelationship(id);
            return ResponseEntity.ok().body(relationship);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Relationship not found");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllRelationships() {
        try {
            List<Relationship> relationships = relationshipService.getAllRelationships();
            return ResponseEntity.ok().body(relationships);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Relationships not found");
        }
    }

    @GetMapping("character/{characterId}/target/{targetId}")
    public ResponseEntity<?> getRelationshipByCharacters(@PathVariable Long characterId, @PathVariable Long targetId) {
        try {
            Relationship relationship = relationshipService.getRelationshipByCharacters(characterId, targetId);
            return ResponseEntity.ok().body(relationship);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Relationship not found");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRelationship( @RequestBody Relationship relationship) {
        try {
            relationshipService.updateRelationship( relationship);
            return ResponseEntity.ok().body("Relationship updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Relationship not found");
        }
    }

    @DeleteMapping("/Character/{id}/Target/{targetId}")
    public ResponseEntity<?> deleteRelationship(@PathVariable Long id, @PathVariable Long targetId) {
        try {
            relationshipService.deleteRelationship(id, targetId);
            return ResponseEntity.ok().body("Relationship deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Relationship not found");
        }
    }
}
