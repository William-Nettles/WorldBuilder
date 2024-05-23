package com.clquinn.models.character;

import com.clquinn.models.setting.World;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "races")
@Component
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "world_id")
    private World world;

    @JsonIgnore
    @OneToMany(mappedBy = "race", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subrace> subraces;

    @JsonIgnore
    @OneToMany(mappedBy = "race", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Character> characters;

    public Race () {
    }

    public Race(Long id, String name, String description, String image, World world, List<Subrace> subraces, List<Character> characters) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.world = world;
        this.subraces = subraces;
        this.characters = characters;
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

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public List<Subrace> getSubraces() {
        return subraces;
    }

    public void setSubraces(List<Subrace> subraces) {
        this.subraces = subraces;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", world=" + world +
                ", subraces=" + subraces +
                ", characters=" + characters +
                '}';
    }
}
