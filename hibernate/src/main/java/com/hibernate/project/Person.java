package com.hibernate.project;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "person_details")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;

    @Transient
    private int ex;

    @Column(length = 50)
    private String name;

    //@Temporal(TemporalType.DATE)
    private LocalDate date;
    @Lob
    @Column(name = "person_image")
    private byte[] image;


    public Person(int ex, String name, LocalDate date, byte[] image) {
        this.ex = ex;
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getEx() {
        return ex;
    }

    public void setEx(int ex) {
        this.ex = ex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", ex=" + ex +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
