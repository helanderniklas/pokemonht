package com.example.harkkatyo;

public class State {

    private int statetype;
    private Pokemon pokemon;

    public State(int statetype){
        this.statetype = statetype;
    }

    public int getState(){return statetype;}
}
