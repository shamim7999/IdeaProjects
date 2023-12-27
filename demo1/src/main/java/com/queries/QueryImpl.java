package com.queries;

import com.dao.DbSql;
import com.entity.Tester;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryImpl implements QueryInterface{
    public QueryImpl() {}

    public List<Tester> showAll(String query) {
        try{
            AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
            DbSql dbSql = (DbSql) context.getBean("dbsql");
            Connection conn = dbSql.testConnection();

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            List<Tester> testers = new ArrayList<>();

            Tester tester2;
            while (rs.next()) {
                tester2 = new Tester();
                tester2.setId(rs.getInt(1));
                tester2.setName(rs.getString(2));
                tester2.setAge(rs.getString(3));

                testers.add(tester2);
            }
            return testers;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Tester> queryRow(String query) {
        return showAll(query);
    }

    @Override
    public Object queryById(String query) {
        return null;
    }
}
