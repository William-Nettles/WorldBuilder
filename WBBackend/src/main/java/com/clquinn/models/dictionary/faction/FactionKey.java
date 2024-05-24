package com.clquinn.models.dictionary.faction;

import com.clquinn.models.character.Character;
import com.clquinn.models.character.Faction;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class FactionKey implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faction_id")
    private Faction faction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id")
    private Character character;

    public FactionKey() {
    }

    public FactionKey(Faction faction, Character character) {
        this.faction = faction;
        this.character = character;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "FactionKey{" +
                "faction=" + faction +
                ", character=" + character +
                '}';
    }



}
