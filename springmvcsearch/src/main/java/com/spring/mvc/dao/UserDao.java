package com.spring.mvc.dao;

import com.spring.mvc.model.User;
import org.hibernate.FlushMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int saveUser(User user) {
        int affectedRow = 0;
        affectedRow = (Integer) this.getHibernateTemplate().save(user);
        return affectedRow;
    }

    public User getUserById(int id) {
        return this.hibernateTemplate.get(User.class, id);
    }
}
