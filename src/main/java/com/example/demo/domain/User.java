package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private long contactNumber;

    public User(int userId, String firstName, String lastName, String userName, String password, long contactNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", userName='" + userName + '\'' + ", password='" + password + '\'' + ", contactNumber=" + contactNumber + '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
