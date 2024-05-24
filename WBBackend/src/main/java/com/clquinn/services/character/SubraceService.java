package com.clquinn.services.character;

import com.clquinn.daos.character.SubraceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubraceService {

    private SubraceDAO subraceDAO;

    @Autowired
    public SubraceService(SubraceDAO subraceDAO) {
        this.subraceDAO = subraceDAO;
    }

}
