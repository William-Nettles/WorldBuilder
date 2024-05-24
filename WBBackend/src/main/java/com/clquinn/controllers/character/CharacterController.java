package com.clquinn.controllers.character;

import com.clquinn.models.character.Character;
import com.clquinn.services.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<?> createCharacter(@RequestBody Character character) {
        try {
            characterService.createCharacter(character);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Character not created");
        }
        return ResponseEntity.ok().body("Character created");
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

    @GetMapping("/all")
    public ResponseEntity<?> getAllCharacters() {
        try {
            List<Character> characters = characterService.getAllCharacters();
            return ResponseEntity.ok().body(characters);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Characters not found");
        }
    }

    @GetMapping("last_name/{lastName}")
    public ResponseEntity<?> getCharactersByLastName(@PathVariable String lastName) {
        try {
            List<Character> characters = characterService.getCharactersByLastName(lastName);
            return ResponseEntity.ok().body(characters);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Characters not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        try {
            characterService.updateCharacter(id, character);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Character not updated");
        }
        return ResponseEntity.ok().body("Character updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable Long id) {
        try {
            characterService.deleteCharacter(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Character not deleted");
        }
        return ResponseEntity.ok().body("Character deleted");
    }

}
