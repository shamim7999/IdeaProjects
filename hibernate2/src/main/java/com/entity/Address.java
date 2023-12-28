package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Address {
    @Id
    private int id;
    private String addressType;
    private String address;

    @ManyToOne
    private Employee employee;

    public Address(int id, String addressType, String address) {
        this.id = id;
        this.addressType = addressType;
        this.address = address;
    }

    public Address() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressType='" + addressType + '\'' +
                ", address='" + address + '\'' +
                ", employee=" + employee +
                '}';
    }
}
