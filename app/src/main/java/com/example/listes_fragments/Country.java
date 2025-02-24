package com.example.listes_fragments;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private String capital;
    private int flagResource; // Image du drapeau

    public Country(String name, String capital, int flagResource) {
        this.name = name;
        this.capital = capital;
        this.flagResource = flagResource;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getFlagResource() {
        return flagResource;
    }
}
