package com.clquinn.services.setting;

import com.clquinn.daos.setting.LocationDAO;
import com.clquinn.models.setting.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationDAO locationDAO;

    @Autowired
    public LocationService(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    public Location createLocation(Location location) {
        if (location == null) {
            throw new RuntimeException("Location cannot be null");
        }
        if (location.getName() == null || location.getName().isEmpty()) {
            throw new RuntimeException("Location name cannot be null or empty");
        }
        if (locationDAO.findByName(location.getName()).isPresent()) {
            throw new RuntimeException("Location with name " + location.getName() + " already exists");
        }

        return locationDAO.save(location);
    }

    public List<Location> getLocations() {
        return locationDAO.findAll();
    }

    public Location getLocation(Long id) {
        return locationDAO.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
    }

    public Location getLocationByName(String name) {
        return locationDAO.findByName(name).orElseThrow(() -> new RuntimeException("Location not found"));
    }

    public Location updateLocation(Long id, Location location) {
        if (locationDAO.existsById(id)) {
            return locationDAO.save(location);
        } else {
            throw new RuntimeException("Location not found");
        }
    }

    public String deleteLocation(Long id) {
        if (locationDAO.existsById(id)) {
            locationDAO.deleteById(id);
            return "Location deleted";
        } else {
            throw new RuntimeException("Location not found");
        }
    }
}
