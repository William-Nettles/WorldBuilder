package com.clquinn.services.setting;

import com.clquinn.daos.setting.WorldDAO;
import com.clquinn.models.setting.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldService {

    private final WorldDAO worldDAO;

    @Autowired
    public WorldService(WorldDAO worldDAO) {
        this.worldDAO = worldDAO;
    }

    public World createWorld(World world) {
        if (world == null) {
            throw new RuntimeException("World cannot be null");
        }
        if (world.getName() == null || world.getName().isEmpty()) {
            throw new RuntimeException("World name cannot be null or empty");
        }
        if (worldDAO.findByName(world.getName()).isPresent()) {
            throw new RuntimeException("World with name " + world.getName() + " already exists");
        }

        return worldDAO.save(world);
    }

    public List<World> getWorlds() {
        return worldDAO.findAll();
    }

    public World getWorld(Long id) {
        return worldDAO.findById(id).orElseThrow(() -> new RuntimeException("World not found"));
    }

    public World getWorldByName(String name) {
        return worldDAO.findByName(name).orElseThrow(() -> new RuntimeException("World not found"));
    }

    public World updateWorld(Long id, World world) {
        if (worldDAO.existsById(id)) {
            return worldDAO.save(world);
        } else {
            throw new RuntimeException("World not found");
        }
    }

    public void deleteWorld(Long id) {
        if (worldDAO.existsById(id)) {
            worldDAO.deleteById(id);
        } else {
            throw new RuntimeException("World not found");
        }
    }
}
