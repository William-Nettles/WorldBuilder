package com.clquinn.daos.dictionary;

import com.clquinn.models.dictionary.relationship.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipDAO extends JpaRepository<Integer, Relationship> {
}
