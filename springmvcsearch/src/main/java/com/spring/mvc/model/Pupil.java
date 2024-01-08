package com.spring.mvc.model;

import java.time.LocalDateTime;
import java.util.List;

public class Pupil {
    private String name;

    private long id;

    private String date;
    private List<String> subjects;
    private String gender;
    private String type;

    public Pupil(String name, long id, String date, List<String> subjects, String gender, String type) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.subjects = subjects;
        this.gender = gender;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", date=" + date +
                ", subjects=" + subjects +
                ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
