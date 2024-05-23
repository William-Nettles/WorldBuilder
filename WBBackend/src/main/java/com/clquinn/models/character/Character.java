package com.clquinn.models.character;

import com.clquinn.models.dictionaries.faction.FactionRelation;
import com.clquinn.models.dictionaries.relationship.Relationship;
import com.clquinn.models.setting.World;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "characters")
@Component
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "other_names")
    private String otherNames;

    @Column(name = "age")
    private int age;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "date_of_death")
    private String dateOfDeath;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "sex")
    private String sex;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "hair_color")
    private String hairColor;

    @Column(name = "eye_color")
    private String eyeColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "world_id")
    private World world;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subrace_id")
    private Subrace subrace;

    @JsonIgnore
    @OneToMany(mappedBy = "id.character", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FactionRelation> factionRelations;

    @JsonIgnore
    @OneToMany(mappedBy = "id.character", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  List<Relationship> relationships;

    public Character() {
    }

    public Character(Long id, String firstName, String lastName, String otherNames, int age, String dateOfBirth, String dateOfDeath, String description, String image, String sex, int height, int weight, String hairColor, String eyeColor, World world, Race race, Subrace subrace) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherNames = otherNames;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.description = description;
        this.image = image;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.world = world;
        this.race = race;
        this.subrace = subrace;
    }

    public Character(Long id, String firstName, String lastName, String otherNames, int age, String dateOfBirth, String dateOfDeath, String description, String image, String sex, int height, int weight, String hairColor, String eyeColor, World world, Race race, Subrace subrace, List<FactionRelation> factionRelations, List<Relationship> relationships) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherNames = otherNames;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.description = description;
        this.image = image;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.world = world;
        this.race = race;
        this.subrace = subrace;
        this.factionRelations = factionRelations;
        this.relationships = relationships;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Subrace getSubrace() {
        return subrace;
    }

    public void setSubrace(Subrace subrace) {
        this.subrace = subrace;
    }

    public List<FactionRelation> getFactionRelations() {
        return factionRelations;
    }

    public void setFactionRelations(List<FactionRelation> factionRelations) {
        this.factionRelations = factionRelations;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", age=" + age +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfDeath='" + dateOfDeath + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", world=" + world +
                ", race=" + race +
                ", subrace=" + subrace +
                ", factionRelations=" + factionRelations +
                ", relationships=" + relationships +
                '}';
    }
}
