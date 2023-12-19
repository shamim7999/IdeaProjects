package com.spring.jdbc.entity;

import org.springframework.stereotype.Component;

@Component("tester") // ---> If you don't use @Component, then See JdbcConfig Class, how to do it manually..!
public class Tester {
    private int id;
    private String name;
    private String age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Tester(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Tester(){}

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}