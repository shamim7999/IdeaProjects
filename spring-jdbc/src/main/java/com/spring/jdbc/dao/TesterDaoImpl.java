package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Tester;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TesterDaoImpl implements TesterDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Tester tester) {
        String query = "insert into tester (name, age) values(?, ?)";
        this.jdbcTemplate.update(query, tester.getName(), tester.getAge());
        System.out.println("Record Inserted......");
        return 0;
    }

    @Override
    public int change(Tester tester) {
        String query = "update tester set name=?, age=? where id=?";
        this.jdbcTemplate.update(query, tester.getName(), tester.getAge(), tester.getId());
        System.out.println("Record Updated......");
        return 0;
    }

    public int delete(Tester tester) {
        String query = "delete from tester where id=?";
        this.jdbcTemplate.update(query, tester.getId());
        System.out.println("Record Deleted for id: "+tester.getId());
        return 0;
    }

    public Tester showAllRecords(int testerId) {
        String query = "select * from tester where id=?";
        RowMapper<Tester> rowMapper = new RowMapperImpl();
        Tester tester1 = this.jdbcTemplate.queryForObject(query, rowMapper, testerId);


        System.out.println("Records Shown for id: "+testerId);
        return tester1;
    }
    public List<Tester> showAllRecords() {
        String query = "select * from tester";

        RowMapperCustom<Tester> rmc = new RowMapperCustomImpl();

        return (List<Tester>) rmc.queryRow(query);
    }

    public TesterDaoImpl(){}
}
