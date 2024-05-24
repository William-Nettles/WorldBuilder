package com.clquinn.models.dictionary.atlas;

import com.clquinn.models.setting.Location;
import com.clquinn.models.setting.Map;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class ChartKey implements Serializable {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "map_id")
    private Map map;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public ChartKey() {
    }

    public ChartKey(Map map, Location location) {
        this.map = map;
        this.location = location;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ChartKey{" +
                "map=" + map +
                ", location=" + location +
                '}';
    }
}
