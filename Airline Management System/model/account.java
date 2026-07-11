/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Account class represents an account entity.
 * Each account has a Username, Password, Email, Permissions, and PassportNumber.
 */
public class account {
    private String username; // Primary key
    private String password;
    private String email;
    private String permissions;
    private int passportNumber; // Foreign key for Passport class

    public account() {
    }

    public account(String username, String password, String email, String permissions, int passportNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.permissions = permissions;
        this.passportNumber = passportNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
