package com.filters.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GetConnection {

    public static String url = "jdbc:mysql://localhost:3306/imon";
    public static String mysqlUserName = "root";
    public static String mysqlPassword = "";

    public static String driver = "com.mysql.cj.jdbc.Driver";

    public GetConnection() {}

    public static Connection getConnection() {

        try{
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, mysqlUserName, mysqlPassword);
            return connection;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
