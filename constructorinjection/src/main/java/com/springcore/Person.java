package com.springcore;

import java.util.List;

public class Person {
    private String name;
    private int personId;

    private Certi certi;

    private List<String> courses;
    public Person(String name, int personId, Certi certi, List<String> courses) {
        this.name = name;
        this.personId = personId;
        this.certi = certi;
        this.courses = courses;
    }

//    public Person(Certi certi) {
//
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", personId=" + personId +
                ", certi=" + certi +
                ", courses=" + courses +
                '}';
    }
}
