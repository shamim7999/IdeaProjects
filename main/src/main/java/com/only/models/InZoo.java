package com.only.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class InZoo {

    @Autowired
    @Qualifier("human1")
    private Human human;


    public InZoo(Human human) {
        this.human = human;
    }

    public InZoo() {
    }

    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return "InZoo{" +
                "human=" + human +
                '}';
    }
}
