package com.clquinn.models.setting;

import com.clquinn.models.character.Character;
import com.clquinn.models.character.Faction;
import com.clquinn.models.character.Race;
import com.clquinn.models.character.Subrace;
import com.clquinn.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "worlds")
@Component
public class World {

    private static final Logger log = LoggerFactory.getLogger(World.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(name = "splash_image")
    private String splashImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "world", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> events;

    @JsonIgnore
    @OneToMany(mappedBy = "world", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Location> locations;

    @JsonIgnore
    @OneToMany(mappedBy = "world", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Character> characters;

    @JsonIgnore
    @OneToMany(mappedBy = "world", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Map> maps;

    @JsonIgnore
    @OneToMany(mappedBy = "world", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Faction> factions;

    @JsonIgnore
    @OneToMany(mappedBy = "world", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Race> races;

    @JsonIgnore
    @OneToMany(mappedBy = "world", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subrace> subraces;

    public World() {
    }

    public World(String name, String genre, String description, String image, boolean isPublic, String splashImage) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.image = image;
        this.isPublic = isPublic;
        this.splashImage = splashImage;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getSplashImage() {
        return splashImage;
    }

    public void setSplashImage(String splashImage) {
        this.splashImage = splashImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    public List<Faction> getFactions() {
        return factions;
    }

    public void setFactions(List<Faction> factions) {
        this.factions = factions;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public List<Subrace> getSubraces() {
        return subraces;
    }

    public void setSubraces(List<Subrace> subraces) {
        this.subraces = subraces;
    }

    @Override
    public String toString() {
        return "World{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", isPublic=" + isPublic +
                ", splashImage='" + splashImage + '\'' +
                ", user=" + user +
                ", events=" + events +
                ", locations=" + locations +
                ", characters=" + characters +
                ", maps=" + maps +
                ", factions=" + factions +
                ", races=" + races +
                ", subraces=" + subraces +
                '}';
    }
}
