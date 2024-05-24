package com.clquinn.daos.setting;

import com.clquinn.models.setting.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDAO extends JpaRepository<Event, Long> {
}
