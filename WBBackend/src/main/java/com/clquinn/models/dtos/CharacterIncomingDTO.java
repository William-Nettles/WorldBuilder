package com.clquinn.models.dtos;

public class CharacterIncomingDTO {


    private String firstName;
    private String lastName;
    private String otherNames;
    private int age;
    private String dateOfBirth;
    private String dateOfDeath;
    private String description;
    private String image;
    private String sex;
    private int height;
    private int weight;
    private String hairColor;
    private String eyeColor;
    private String worldName;
    private String raceName;
    private String subraceName;
    private int worldId;


    public CharacterIncomingDTO() {
    }

    public CharacterIncomingDTO(Long id, String firstName, String lastName, String otherNames, int age, String dateOfBirth, String dateOfDeath, String description, String image, String sex, int height, int weight, String hairColor, String eyeColor, String worldName, String raceName, String subraceName, int worldId) {

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
        this.worldName = worldName;
        this.raceName = raceName;
        this.subraceName = subraceName;
        this.worldId = worldId;
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

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getSubraceName() {
        return subraceName;
    }

    public void setSubraceName(String subraceName) {
        this.subraceName = subraceName;
    }

    public long getWorldId() {
        return worldId;
    }

    public void setWorldId(int worldId) {
        this.worldId = worldId;
    }

    @Override
    public String toString() {
        return "CharacterIncomingDTO{" +
                "firstName='" + firstName + '\'' +
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
                ", worldName='" + worldName + '\'' +
                ", raceName='" + raceName + '\'' +
                ", subraceName='" + subraceName + '\'' +
                '}';
    }
}
