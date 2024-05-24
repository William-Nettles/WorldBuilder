package com.clquinn.daos.dictionary;

import com.clquinn.models.dictionary.atlas.Chart;
import com.clquinn.models.setting.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtlasDAO extends JpaRepository<Chart, Long> {
    Optional<Chart> findById_Location_IdAndId_Map_Id(Long id, Long id1);

    List<Chart> findById_Location_Id(Long id);

    List<Chart> findById_Map_Id(Long id);

    boolean existsById_Location_IdAndId_Map_Id(Long locationId, Long mapId);

    void deleteById_Location_IdAndId_Map_Id(Long locationId, Long mapId);
}
