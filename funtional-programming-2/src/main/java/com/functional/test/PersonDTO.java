package com.functional.test;

public class PersonDTO {
    private String name;
    private String age;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public PersonDTO(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public PersonDTO() {

    }
}
