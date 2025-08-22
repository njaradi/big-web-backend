package org.example.bigwebbackend.entites;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
    private int id;
    @NotNull(message = "email name is required")
    @NotEmpty(message = "email name is required")
    private String email;

    @NotNull(message = "user name is required")
    @NotEmpty(message = "user name is required")
    private String name;

    @NotNull(message = "user surname is required")
    @NotEmpty(message = "user surname is required")
    private String surname;
    private UserType userType;
    private Status status;
    private String hashedPassword;//todo: has to be a hash value

    public User(String hashedPassword, Status status, UserType userType, String surname, String name, String email, int id) {
        this.hashedPassword = hashedPassword;
        this.status = status;
        this.userType = userType;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
