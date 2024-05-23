package com.clquinn.models.dictionaries.relationship;

import com.clquinn.models.character.Character;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class RelationshipKey implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private Character character;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_character_id")
    private Character targetCharacter;

    public RelationshipKey() {
    }

    public RelationshipKey(Character character, Character targetCharacter) {
        this.character = character;
        this.targetCharacter = targetCharacter;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getTargetCharacter() {
        return targetCharacter;
    }

    public void setTargetCharacter(Character targetCharacter) {
        this.targetCharacter = targetCharacter;
    }

    @Override
    public String toString() {
        return "RelationshipKey{" +
                "character=" + character +
                ", targetCharacter=" + targetCharacter +
                '}';
    }
}
