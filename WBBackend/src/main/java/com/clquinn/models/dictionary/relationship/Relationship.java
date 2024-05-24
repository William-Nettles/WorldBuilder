package com.clquinn.models.dictionary.relationship;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "relationships")
@Component
public class Relationship  {

    @EmbeddedId
    private RelationshipKey id;

    @Column(name = "relationship")
    private String relationship;

    public Relationship() {
    }

    public Relationship(RelationshipKey id, String relationship) {
        this.id = id;
        this.relationship = relationship;
    }

    public RelationshipKey getId() {
        return id;
    }

    public void setId(RelationshipKey id) {
        this.id = id;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}
