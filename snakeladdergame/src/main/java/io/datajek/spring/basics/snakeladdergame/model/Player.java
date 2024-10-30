package io.datajek.spring.basics.snakeladdergame.model;

import org.springframework.stereotype.Component;

import java.util.UUID;

public class Player {

    private String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }


    public String getName() {
        return this.name;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
