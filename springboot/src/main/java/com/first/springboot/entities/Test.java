package com.first.springboot.entities;

import org.springframework.stereotype.Component;

@Component
public class Test {
    int x;

    public Test(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "x=" + x +
                '}';
    }
}
