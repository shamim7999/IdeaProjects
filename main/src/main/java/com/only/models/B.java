package com.only.models;

public class B {
    private String city;

    public B(String city) {
        this.city = city;
    }

    public B() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "B{" +
                "city='" + city + '\'' +
                '}';
    }
}
