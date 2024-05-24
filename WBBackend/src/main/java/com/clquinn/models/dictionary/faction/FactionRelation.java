package com.clquinn.models.dictionary.faction;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "faction_relations")
@Component
public class FactionRelation {

    @EmbeddedId
    private FactionKey id;

    public FactionRelation() {
    }

    public FactionRelation(FactionKey id) {
        this.id = id;
    }

    public FactionKey getId() {
        return id;
    }

    public void setId(FactionKey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FactionRelation{" +
                "id=" + id +
                '}';
    }

}
