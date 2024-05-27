package com.clquinn.controllers.setting;

import com.clquinn.models.setting.World;
import com.clquinn.services.setting.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worlds")
@CrossOrigin(origins = "http://localhost:3000")
public class WorldController {

    private final WorldService worldService;

    @Autowired
    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @PostMapping
    public ResponseEntity<Object> createWorld(@RequestBody World world) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(worldService.createWorld(world));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getWorlds() {
        try {
            return ResponseEntity.ok(worldService.getWorlds());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorld(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(worldService.getWorld(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getWorldByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(worldService.getWorldByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWorld(@PathVariable Long id, @RequestBody World world) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(worldService.updateWorld(id, world));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWorld(@PathVariable Long id) {
        try {
            worldService.deleteWorld(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(("World deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
        }
    }

}
