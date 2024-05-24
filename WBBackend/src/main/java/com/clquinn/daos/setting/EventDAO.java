package com.clquinn.daos.setting;

import com.clquinn.models.setting.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventDAO extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);
}
