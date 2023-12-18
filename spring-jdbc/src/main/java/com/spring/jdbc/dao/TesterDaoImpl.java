package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Tester;
import org.springframework.jdbc.core.JdbcTemplate;

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

    public TesterDaoImpl(){}
}
