package com.clquinn.daos.character;

import com.clquinn.models.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterDAO extends JpaRepository<Character, Long> {
    List<Character> findByLastName(String lastName);

    Optional<Object> findByFirstNameAndLastNameAndOtherNamesAndWorld_Id(String firstName, String lastName, String otherNames, Long id);
    Optional<Object> findByFirstNameAndLastNameAndOtherNames(String firstName, String lastName, String otherNames);

}
