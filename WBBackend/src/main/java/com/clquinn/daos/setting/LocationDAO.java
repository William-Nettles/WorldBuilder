package com.clquinn.daos.setting;

import com.clquinn.models.setting.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationDAO extends JpaRepository<Location, Long> {
    Optional<Location> findByName(String name);
}
