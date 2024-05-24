package com.clquinn.daos.setting;

import com.clquinn.models.setting.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDAO extends JpaRepository<Location, Long> {
}
