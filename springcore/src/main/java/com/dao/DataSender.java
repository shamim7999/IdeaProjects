package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSender extends Database{
    String myQuery;

    public String getMyQuery() {
        return myQuery;
    }

    public void setMyQuery(String myQuery) {

        this.myQuery = myQuery;
    }

    public DataSender(String myQuery) {
        this.myQuery = myQuery;
    }

    public DataSender() {
        super();
    }
//    public void sendData() {
//        try {
//            Class.forName(super.getDriver());
//
//            Connection conn = DriverManager.getConnection(super.getUrl(), super.getDriver(), super.getPassword());
//            System.out.println("Connected Succesfully");
//
//
//            PreparedStatement ps = conn.prepareStatement(myQuery);
//
//            ps.setString(1, super.getName());
//            ps.setString(2, super.getCourse());
//            ps.setString(3, super.getAge());
//            ps.setString(4, super.getEmail());
//
//            ps.executeUpdate();
//
//        } catch(ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            System.err.println(e.getMessage());
//        }
//    }
}
