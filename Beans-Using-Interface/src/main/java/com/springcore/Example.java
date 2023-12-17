package com.springcore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting Example Parameter.");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Example{" +
                "name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void start() {
        System.out.println("init() Using @PostConstruct");
    }

    @PreDestroy
    public void stop() {
        System.out.println("destroy() Using @PreDestroy");
    }
}
