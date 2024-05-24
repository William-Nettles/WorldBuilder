package com.clquinn.daos.dictionary;

import com.clquinn.models.dictionary.faction.FactionRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionRelationDAO extends JpaRepository<Integer, FactionRelation> {
}
