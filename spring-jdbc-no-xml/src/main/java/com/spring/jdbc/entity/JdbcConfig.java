package com.spring.jdbc.entity;

import com.spring.jdbc.dao.TesterDao;
import com.spring.jdbc.dao.TesterDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao", "com.spring.jdbc.entity"})
public class JdbcConfig {
    @Bean("driverManagerDataSource")
    public DataSource getDataSource() { /// ----> DataSource is Interface
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/shamim");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");

        return driverManagerDataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return  jdbcTemplate;
    }





//    @Bean("testerDaoImpl")
//    public TesterDao getTesterDaoImpl() { /// -----> TesterDao is Interface
//        TesterDaoImpl testerDao = new TesterDaoImpl();
//        testerDao.setJdbcTemplate(getJdbcTemplate());
//        return testerDao;
//    }

    // The @Bean("testerDaoImpl") declared is correct. The another way is defined in Class TesterDaoImpl.
    // Also we have to add @ComponentScan(basePackages={"package1", "package2", .. }) in this file after @Configuration Annotation.



//    @Bean("tester")
//    //@Scope("prototype")
//    public Tester getTester() {
//        Tester tester = new Tester();
//        tester.setAge("");
//        tester.setName("");
//        tester.setId(0);
//
//        return tester;
//    }

    // The @Bean("tester") declared is correct. The another way is defined in Class Tester.
    // Also we have to add @ComponentScan(basePackages={"package1", "package2", .. }) in this file after @Configuration Annotation.


}
