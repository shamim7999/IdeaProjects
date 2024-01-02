package com.filters.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    String query = "Select * from login where user_name=? and password=?";
    public LoginDao() {}

    public boolean check(String userName, String password) {
        try{
            PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return true;
            }
            return false;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
