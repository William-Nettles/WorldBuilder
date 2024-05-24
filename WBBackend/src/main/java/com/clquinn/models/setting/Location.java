package com.clquinn.models.setting;

import com.clquinn.models.dictionary.atlas.Chart;
import com.clquinn.models.character.Faction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "locations")
@Component
public class Location {

    private static final Logger log = LoggerFactory.getLogger(Location.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "year_established")
    private int yearEstablished;

    @Column(name  = "year_destroyed")
    private int yearDestroyed;

    @Column(name = "is_capital")
    private boolean isCapital;

    @Column(name = "is_coastal")
    private boolean isCoastal;

    @Column(name = "population")
    private int population;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "world_id")
    private World world;

    @JsonIgnore
    @OneToMany(mappedBy = "id.location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Chart> charts;

    @JsonIgnore
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> events;

    @JsonIgnore
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Faction> factions;

    public Location() {
    }

    public Location(String name, String description, String image, int yearEstablished, int yearDestroyed, boolean isCapital, boolean isCoastal, int population, double latitude, double longitude) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.yearEstablished = yearEstablished;
        this.yearDestroyed = yearDestroyed;
        this.isCapital = isCapital;
        this.isCoastal = isCoastal;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public int getYearDestroyed() {
        return yearDestroyed;
    }

    public void setYearDestroyed(int yearDestroyed) {
        this.yearDestroyed = yearDestroyed;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public boolean isCoastal() {
        return isCoastal;
    }

    public void setCoastal(boolean coastal) {
        isCoastal = coastal;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Faction> getFactions() {
        return factions;
    }

    public void setFactions(List<Faction> factions) {
        this.factions = factions;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", yearEstablished=" + yearEstablished +
                ", yearDestroyed=" + yearDestroyed +
                ", isCapital=" + isCapital +
                ", isCoastal=" + isCoastal +
                ", population=" + population +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", world=" + world +
                ", charts=" + charts +
                ", events=" + events +
                ", factions=" + factions +
                '}';
    }
}
