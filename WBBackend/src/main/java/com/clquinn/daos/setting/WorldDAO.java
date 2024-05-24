package com.clquinn.daos.setting;

import com.clquinn.models.setting.World;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldDAO extends JpaRepository<Integer, World> {
}
