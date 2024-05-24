package com.clquinn.daos.character;

import com.clquinn.models.character.Subrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubraceDAO extends JpaRepository<Integer, Subrace>{

}
