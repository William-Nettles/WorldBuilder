package com.clquinn.controllers.setting;

import com.clquinn.models.setting.Event;
import com.clquinn.services.setting.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Object> createEvent(@RequestBody Event event) {
        try {
            return ResponseEntity.ok(eventService.createEvent(event));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getEvents() {
        try {
            return ResponseEntity.ok(eventService.getEvents());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvent(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(eventService.getEvent(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getEventByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(eventService.getEventByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        try {
            return ResponseEntity.ok(eventService.updateEvent(id, event));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(eventService.deleteEvent(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
