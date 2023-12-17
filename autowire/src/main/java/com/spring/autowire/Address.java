package com.spring.autowire;

import java.util.List;

public class Address {
    private List<String> city;

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }
    public Address(){}

    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                '}';
    }
}
