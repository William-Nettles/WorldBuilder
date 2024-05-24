package com.clquinn.services.character;

import com.clquinn.daos.character.SubraceDAO;
import com.clquinn.models.character.Subrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubraceService {

    private SubraceDAO subraceDAO;

    @Autowired
    public SubraceService(SubraceDAO subraceDAO) {
        this.subraceDAO = subraceDAO;
    }

    public Object createSubrace(Subrace subrace) {
        if (subrace == null) {
            return "Subrace cannot be null";
        }

        if (subrace.getName() == null || subrace.getName().isEmpty()) {
            return "Subrace name cannot be null or empty";
        }

        if (subraceDAO.findByName(subrace.getName()).isPresent()) {
            return "Subrace with name " + subrace.getName() + " already exists";
        }

        return subraceDAO.save(subrace);
    }

    public Object getSubraces() {
        return subraceDAO.findAll();
    }

    public Object getSubrace(Long id) {
        return subraceDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Subrace with id " + id + " not found"));
    }

    public Object updateSubrace(Long id, Subrace subrace) {
        Subrace existingSubrace = subraceDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Subrace with id " + id + " not found"));
        existingSubrace.setName(subrace.getName());
        existingSubrace.setDescription(subrace.getDescription());
        existingSubrace.setImage(subrace.getImage());
        return subraceDAO.save(existingSubrace);
    }

    public Object deleteSubrace(Long id) {
        if (subraceDAO.existsById(id)) {
            subraceDAO.deleteById(id);
            return "successfully deleted";
        } else {
            throw new IllegalArgumentException("Subrace with id " + id + " not found");
        }
    }
}
