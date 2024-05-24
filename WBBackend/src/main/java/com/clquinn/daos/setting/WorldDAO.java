package com.clquinn.daos.setting;

import com.clquinn.models.setting.World;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorldDAO extends JpaRepository<World, Long> {
    Optional<World> findByName(String worldName);
}
