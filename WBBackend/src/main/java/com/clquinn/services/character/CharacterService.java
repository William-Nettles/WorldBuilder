package com.clquinn.services.character;

import com.clquinn.daos.character.CharacterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private CharacterDAO characterDAO;

    @Autowired
    public CharacterService(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

}
