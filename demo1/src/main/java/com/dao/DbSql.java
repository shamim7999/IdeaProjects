package com.dao;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbSql {
    private String driver;
    private String url;
    private String userName;
    private String password;

    private String name, email, course, age, id;

    private String regEmail, regPassword;

    public void setId(String id) {
        this.id = id;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
    }

    public void setRegPassword(String regPassword) {
        this.regPassword = regPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public DbSql(){}

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void sendData() {


        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected Succesfully");

            String myQuery = "INSERT INTO person (id, name, course, age, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(myQuery);

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setString(4, age);
            ps.setString(5, email);

            ps.executeUpdate();

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public void sendRegData() {
        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected Succesfully");

            String myQuery = "INSERT INTO reg (email, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(myQuery);

            ps.setString(1, regEmail);
            ps.setString(2, regPassword);

            ps.executeUpdate();

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public String checkEmail(String record) {
        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected Succesfully");

            String myQuery = "SELECT * FROM reg WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(myQuery);

            //ps.setString(1, table);
            ps.setString(1, record);

            ResultSet resultSet = ps.executeQuery();



            if(resultSet.next()) {
                return resultSet.getString("id");
            }
            return null;

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }
}
