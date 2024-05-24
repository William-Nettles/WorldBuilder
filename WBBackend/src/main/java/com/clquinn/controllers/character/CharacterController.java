package com.clquinn.controllers.character;

import com.clquinn.models.character.Character;
import com.clquinn.models.dtos.CharacterIncomingDTO;
import com.clquinn.services.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<?> createCharacter(@RequestBody CharacterIncomingDTO character) {
        try {
            characterService.createCharacter(character);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Character not created: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Character created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCharacter(@PathVariable Long id) {
        try {
            Character character = characterService.getCharacter(id);
            return ResponseEntity.ok().body(character);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Character not found");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCharacters() {
        try {
            List<Character> characters = characterService.getAllCharacters();
            return ResponseEntity.ok().body(characters);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Characters not found");
        }
    }

    @GetMapping("last_name/{lastName}")
    public ResponseEntity<?> getCharactersByLastName(@PathVariable String lastName) {
        try {
            List<Character> characters = characterService.getCharactersByLastName(lastName);
            return ResponseEntity.ok().body(characters);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Characters not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCharacter(@PathVariable Long id, @RequestBody CharacterIncomingDTO character) {
        try {
            characterService.updateCharacter(id, character);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Character not updated");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Character updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable Long id) {
        try {
            characterService.deleteCharacter(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.GONE).body("Character not deleted");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Character deleted");
    }

}
