package com.clquinn.models.character;

import com.clquinn.models.dictionaries.faction.FactionRelation;
import com.clquinn.models.setting.Location;
import com.clquinn.models.setting.World;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "factions")
@Component
public class Faction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name ="type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "world_id")
    private World world;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @JsonIgnore
    @OneToMany(mappedBy = "id.faction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FactionRelation> relations;

    public Faction() {
    }

    public Faction(String name, String description, String image, String type) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<FactionRelation> getRelations() {
        return relations;
    }

    public void setRelations(List<FactionRelation> relations) {
        this.relations = relations;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", world=" + world +
                ", location=" + location +
                ", relations=" + relations +
                '}';
    }
}
