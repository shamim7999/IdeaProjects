package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RowMapperCustomImpl implements RowMapperCustom{

    public RowMapperCustomImpl() {
    }

    public List<Tester> showAll(String query) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/shamim";
            String userName = "root";
            String password="";

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            List<Tester> testers = new ArrayList<>();
            while(rs.next()) {
                Tester tester2 = new Tester();
                tester2.setId(rs.getInt(1));
                tester2.setName(rs.getString(2));
                tester2.setAge(rs.getString(3));

                testers.add(tester2);
            }

            return testers;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tester> queryRow(String query) {
        return showAll(query);
    }

    public Tester queryById(String query) { return null;}
}
