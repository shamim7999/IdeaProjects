package com.spring.mvc.dao;

import com.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int saveUser(User user) {
        String query = "Insert into User (userId, userName, userEmail, userPassword) values (?,?,?,?)";
        int i = this.jdbcTemplate.update(query, user.getUserId(), user.getUserName(), user.getUserEmail(), user.getUserPassword());
        return i;
    }
}
