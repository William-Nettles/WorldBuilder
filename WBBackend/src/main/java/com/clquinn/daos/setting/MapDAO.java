package com.clquinn.daos.setting;

import com.clquinn.models.setting.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapDAO extends JpaRepository<Integer, Map> {
}
