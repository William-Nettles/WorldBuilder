package com.clquinn.controllers.setting;

import com.clquinn.models.setting.Location;
import com.clquinn.services.setting.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Object> createLocation(@RequestBody Location location) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(locationService.createLocation(location));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getLocations() {
        try {
            return ResponseEntity.ok(locationService.getLocations());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLocation(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(locationService.getLocation(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getLocationByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(locationService.getLocationByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(locationService.updateLocation(id, location));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLocation(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(locationService.deleteLocation(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
