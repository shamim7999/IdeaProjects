package com.first.springboot.model;


import jakarta.persistence.*;

@Entity
public class Registered {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 20)
    private String userName;
    @Column(length = 20)
    private String userPassword;

    @Transient
    @Column(length = 20)
    private String userConfirmPassword;

    public Registered() {
    }

    public Registered(int id, String userName, String userPassword, String userConfirmPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userConfirmPassword = userConfirmPassword;
    }

    public Registered(String userName, String userPassword, String userConfirmPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userConfirmPassword = userConfirmPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserConfirmPassword() {
        return userConfirmPassword;
    }

    public void setUserConfirmPassword(String userConfirmPassword) {
        this.userConfirmPassword = userConfirmPassword;
    }

    @Override
    public String toString() {
        return "Registered{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userConfirmPassword='" + userConfirmPassword + '\'' +
                '}';
    }
}
