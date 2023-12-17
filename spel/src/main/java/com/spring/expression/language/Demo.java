package com.spring.expression.language;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")  ---> Gives different objects
//@Scope("singleton") or By not giving @Scope Annotation it becomes Singleton
public class Demo {
    @Value("#{22+11}")
    private int x;
    @Value("#{8 > 6 ? 5 : 6}")
    private int y;

    @Value("#{T(java.lang.Math).sqrt(625)}")
    private double a;
    @Value("#{T(java.lang.Math).PI}")
    private int b;

    private int c;

    //@Value("#{new com.spring.expression.language.Person()}") ----> Didn't work
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "x=" + x +
                ", y=" + y +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", Person=" + person +
                '}';
    }

    public Demo(){}
}
