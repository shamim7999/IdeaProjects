package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private String driver;
    private String url;
    private String userName;
    private String password;

    private String name, email, age, course, myQuery;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Database(String name, String email, String age, String course) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.course = course;
    }

    public Database() {

    }

    public void setMyQuery(String myQuery) {
        this.myQuery = myQuery;
    }

    @Override
    public String toString() {
        sendData();
        return "Database{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public void sendData() {
        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected Succesfully");

            PreparedStatement ps = conn.prepareStatement(myQuery);

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, age);
            ps.setString(4, email);

            ps.executeUpdate();

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
