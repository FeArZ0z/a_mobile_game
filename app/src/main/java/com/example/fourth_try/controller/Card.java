package com.example.fourth_try.controller;

public class Card {
    public String text, sips, kategorie;

    public Card(String text, String sips, String kategorie){
        this.text = text;
        this.sips = sips;
        this.kategorie = kategorie;
    }

    public String getText() {
        return text;
    }

    public String getSips() {
        return sips;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSips(String sips) {
        this.sips = sips;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }
}
