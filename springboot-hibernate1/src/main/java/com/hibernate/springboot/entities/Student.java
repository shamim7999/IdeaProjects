package com.hibernate.springboot.entities;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rollNo;
    private String name;
    @OneToOne
    private Laptop laptop;

    public Laptop getLaptop() {
        return laptop;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
