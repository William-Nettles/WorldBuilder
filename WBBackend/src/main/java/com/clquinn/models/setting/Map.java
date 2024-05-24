package com.clquinn.models.setting;

import com.clquinn.models.dictionary.atlas.Chart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "maps")
@Component
public class Map {

    private static final Logger log = LoggerFactory.getLogger(Map.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "root_x")
    private int rootX;

    @Column(name = "root_y")
    private int rootY;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "world_id")
    private World world;

    @JsonIgnore
    @OneToMany(mappedBy = "id.map", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Chart>charts;

    public Map() {
    }

    public Map(String name, String description, String image, int rootX, int rootY) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.rootX = rootX;
        this.rootY = rootY;
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

    public int getRootX() {
        return rootX;
    }

    public void setRootX(int rootX) {
        this.rootX = rootX;
    }

    public int getRootY() {
        return rootY;
    }

    public void setRootY(int rootY) {
        this.rootY = rootY;
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

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", rootX=" + rootX +
                ", rootY=" + rootY +
                ", world=" + world +
                ", charts=" + charts +
                '}';
    }
}
