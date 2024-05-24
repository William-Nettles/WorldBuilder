package com.clquinn.models.dtos;

public class UserLoginDTO {

    private String Username;
    private String Password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" + "Username=" + Username + ", Password=" + Password + '}';
    }

}
