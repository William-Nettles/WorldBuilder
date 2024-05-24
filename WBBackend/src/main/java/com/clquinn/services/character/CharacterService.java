package com.clquinn.services.character;

import com.clquinn.daos.character.CharacterDAO;
import com.clquinn.daos.character.RaceDAO;
import com.clquinn.daos.character.SubraceDAO;
import com.clquinn.daos.setting.WorldDAO;
import com.clquinn.models.character.Character;
import com.clquinn.models.character.Race;
import com.clquinn.models.dtos.CharacterIncomingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterDAO characterDAO;
    private final RaceDAO raceDAO;
    private final SubraceDAO subraceDAO;
    private final WorldDAO worldDAO;

    @Autowired
    public CharacterService(CharacterDAO characterDAO, RaceDAO raceDAO, SubraceDAO subraceDAO, WorldDAO worldDAO) {
        this.worldDAO = worldDAO;
        this.subraceDAO = subraceDAO;
        this.raceDAO = raceDAO;
        this.characterDAO = characterDAO;
    }

    public void createCharacter(CharacterIncomingDTO character) {

        if (character == null) {
            throw new RuntimeException("Character cannot be null");
        }
        if (character.getFirstName() == null || character.getFirstName().isEmpty()) {
            throw new RuntimeException("Character first name cannot be null or empty");
        }
        if(characterDAO.findByFirstNameAndLastNameAndOtherNames(character.getFirstName(), character.getLastName(), character.getOtherNames()).isPresent()) {
            throw new RuntimeException("Character with name " + character.getFirstName() + " " + character.getLastName() + " already exists");
        }

        characterDAO.save(parseCharacter(character));
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

    public void updateCharacter(Long id, CharacterIncomingDTO character) {
        if (characterDAO.existsById(id)) {
            characterDAO.save(parseCharacter(character));
        } else throw new RuntimeException("Character with id " + id + " not found");
    }

    public void deleteCharacter(Long id) {
        if (characterDAO.existsById(id)) {
            characterDAO.deleteById(id);
        }  else throw new RuntimeException("Character with id " + id + " not found");
    }

    private Character parseCharacter(CharacterIncomingDTO character) {

        Character newCharacter = new Character();
        newCharacter.setWorld(worldDAO.findByName(character.getWorldName()).orElseThrow(RuntimeException::new));
        newCharacter.setRace( raceDAO.findByName(character.getRaceName()).orElseThrow(RuntimeException::new));
        newCharacter.setSubrace(subraceDAO.findByName(character.getSubraceName()).orElseThrow(RuntimeException::new));
        newCharacter.setFirstName(character.getFirstName());
        newCharacter.setLastName(character.getLastName());
        newCharacter.setAge(character.getAge());
        newCharacter.setSex(character.getSex());
        newCharacter.setDescription(character.getDescription());
        newCharacter.setDateOfBirth(character.getDateOfBirth());
        newCharacter.setDateOfDeath(character.getDateOfDeath());
        newCharacter.setOtherNames(character.getOtherNames());
        newCharacter.setHairColor(character.getHairColor());
        newCharacter.setEyeColor(character.getEyeColor());
        newCharacter.setImage(character.getImage());
        newCharacter.setHeight(character.getHeight());
        newCharacter.setWeight(character.getWeight());

        return newCharacter;
    }

}

