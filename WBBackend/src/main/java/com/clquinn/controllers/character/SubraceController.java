package com.clquinn.controllers.character;

import com.clquinn.models.character.Subrace;
import com.clquinn.services.character.SubraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subrace")
public class SubraceController {

    private SubraceService subraceService;

    @Autowired
    public SubraceController(SubraceService subraceService) {
        this.subraceService = subraceService;
    }

    @PostMapping
    public ResponseEntity<?> createSubrace(@RequestBody Subrace subrace) {
        try {
            return ResponseEntity.ok(subraceService.createSubrace(subrace));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getSubraces() {
        try {
            return ResponseEntity.ok(subraceService.getSubraces());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubrace(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(subraceService.getSubrace(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubrace(@PathVariable Long id, @RequestBody Subrace subrace) {
        try {
            return ResponseEntity.ok(subraceService.updateSubrace(id, subrace));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubrace(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(subraceService.deleteSubrace(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
