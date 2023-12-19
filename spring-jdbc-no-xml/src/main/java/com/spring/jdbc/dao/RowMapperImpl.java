package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Tester;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Tester> {

    @Override
    public Tester mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tester tester = new Tester();
        tester.setId(rs.getInt(1));
        tester.setName(rs.getString(2));
        tester.setAge(rs.getString(3));

        return tester;
    }
}
