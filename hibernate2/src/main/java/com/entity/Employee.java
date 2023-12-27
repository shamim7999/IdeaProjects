package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    @OneToMany
    private List<Address> address;

    public Employee() {

    }

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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Employee(int id, String name, List<Address> address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
