package com.clquinn.daos.dictionary;

import com.clquinn.models.dictionary.atlas.Chart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtlasDAO extends JpaRepository<Integer, Chart> {
}
