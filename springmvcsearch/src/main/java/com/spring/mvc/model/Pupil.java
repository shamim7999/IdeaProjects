package com.spring.mvc.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Pupil {
    private String name;

    private long id;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private List<String> subjects;
    private String gender;
    private String type;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Pupil(String name, long id, Date date, List<String> subjects, String gender, String type) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.subjects = subjects;
        this.gender = gender;
        this.type = type;
    }

    public Pupil() {
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
