package com.example.phase2.Model.User;

abstract public class User {
    private String nameOfUser;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String nameOfUser, String password, String phoneNumber, String email) {
        this.email = email;
        this.nameOfUser = nameOfUser;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
