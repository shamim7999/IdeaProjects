package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/myhiber";
    private static final String userName = "root";
    private static final String password = "";
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userName, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
