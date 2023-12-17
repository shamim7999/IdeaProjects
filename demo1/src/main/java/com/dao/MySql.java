package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySql {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shamim";
    private static final String userName = "root";
    private static final String password = "";

    String name, email, course, age;
    public void sendData() {
        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected Succesfully");

            String myQuery = "INSERT INTO person (name, course, age, email) VALUES (?, ?, ?, ?)";
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
    public MySql(String name, String email, String course, String age) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
        sendData();
    }

}