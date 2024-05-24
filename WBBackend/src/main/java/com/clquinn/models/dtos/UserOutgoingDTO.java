package com.clquinn.models.dtos;

import com.clquinn.models.User;

public class UserOutgoingDTO {

    private Long id;
    private String username;
    private String email;
    private String role;
    private String firstName;
    private String lastName;
    private String aboutMe;
    private String profilePicture;

    public UserOutgoingDTO() {
    }

    public UserOutgoingDTO(Long id, String username, String email, String role, String firstName, String lastName, String aboutMe, String profilePicture) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aboutMe = aboutMe;
        this.profilePicture = profilePicture;
    }

    public UserOutgoingDTO(User user) {
        this.setId(user.getId());
       this.setUsername(user.getUsername());
       this.setEmail(user.getEmail());
       this.setRole(user.getRole());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setAboutMe(user.getAboutMe());
        this.setProfilePicture(user.getProfilePicture());
    }

    @Override
    public String toString() {
        return "UserOutgoingDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
