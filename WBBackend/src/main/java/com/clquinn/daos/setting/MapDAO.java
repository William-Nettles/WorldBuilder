package com.clquinn.daos.setting;

import com.clquinn.models.setting.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MapDAO extends JpaRepository<Map, Long> {
    Optional<Map> findByName(String name);
}
