package com.clquinn.services.character;

import com.clquinn.daos.character.CharacterDAO;
import com.clquinn.models.character.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private CharacterDAO characterDAO;

    @Autowired
    public CharacterService(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    public void createCharacter(Character character) {

        if (character == null) {
            throw new RuntimeException("Character cannot be null");
        }
        if (character.getFirstName() == null || character.getFirstName().isEmpty()) {
            throw new RuntimeException("Character first name cannot be null or empty");
        }


        characterDAO.save(character);
    }

    public Character getCharacter(Long id) {
        return characterDAO.findById(id).orElseThrow(() -> new RuntimeException("Character not found"));
    }

    public List<Character> getAllCharacters() {
        return characterDAO.findAll();
    }

    public List<Character> getCharactersByLastName(String lastName) {
        return characterDAO.findByLastName(lastName);
    }

    public void updateCharacter(Long id, Character character) {
        Character characterToUpdate = characterDAO.findById(id).orElseThrow(() -> new RuntimeException("Character not found"));
        characterToUpdate.setFirstName(character.getFirstName());
        characterToUpdate.setLastName(character.getLastName());
        characterToUpdate.setAge(character.getAge());
        characterToUpdate.setSex(character.getSex());
        characterToUpdate.setRace(character.getRace());
        characterToUpdate.setDescription(character.getDescription());
        characterToUpdate.setDateOfBirth(character.getDateOfBirth());
        characterToUpdate.setDateOfDeath(character.getDateOfDeath());
        characterToUpdate.setOtherNames(character.getOtherNames());
        characterToUpdate.setHairColor(character.getHairColor());
        characterToUpdate.setEyeColor(character.getEyeColor());
        characterToUpdate.setImage(character.getImage());
        characterToUpdate.setSubrace(character.getSubrace());
        characterToUpdate.setRace(character.getRace());
        characterToUpdate.setHeight(character.getHeight());
        characterToUpdate.setWeight(character.getWeight());
        characterDAO.save(characterToUpdate);
    }

    public void deleteCharacter(Long id) {
        characterDAO.deleteById(id);
    }
}
