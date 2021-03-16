package com.example.fourth_try.controller;

public enum KindOfCard {
    NOTHING("Select something first"),
    NORMAL("Normal"),
    CALIENTE("Caliente"),
    QUESTION("Question"),
    CHALLENGE("Challenge"),
    VOTE("Vote");
    
    private String name;
    private KindOfCard(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
