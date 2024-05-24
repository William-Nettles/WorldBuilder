package com.clquinn.services.setting;

import com.clquinn.daos.setting.EventDAO;
import com.clquinn.models.setting.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventDAO eventDAO;

    @Autowired
    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public Event createEvent(Event event) {
        if (event == null) {
            throw new RuntimeException("Event cannot be null");
        }
        if (event.getName() == null || event.getName().isEmpty()) {
            throw new RuntimeException("Event name cannot be null or empty");
        }
        if (eventDAO.findByName(event.getName()).isPresent()) {
            throw new RuntimeException("Event with name " + event.getName() + " already exists");
        }

        return eventDAO.save(event);
    }

    public List<Event> getEvents() {
        return eventDAO.findAll();
    }

    public Event getEvent(Long id) {
        return eventDAO.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event getEventByName(String name) {
        return eventDAO.findByName(name).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event updateEvent(Long id, Event event) {
        if (eventDAO.existsById(id)) {
            return eventDAO.save(event);
        } else {
            throw new RuntimeException("Event not found");
        }
    }

    public String deleteEvent(Long id) {
        if (eventDAO.existsById(id)) {
            eventDAO.deleteById(id);
            return "Event deleted";
        } else {
            throw new RuntimeException("Event not found");
        }
    }
}
