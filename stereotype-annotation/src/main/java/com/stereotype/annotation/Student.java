package com.stereotype.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ob")
// @Component ---> Just eta dile Student class er camel case banay dibe jemon --> student
public class Student {
    @Value("Shamim Sarker")
    private String studentName;
    @Value("Khilgaon, Dhaka")
    private String city;
    @Value("#{temp}")
    private List<String> address;

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Student() {

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", city='" + city + '\'' +
                ", address=" + address +
                '}';
    }
}
