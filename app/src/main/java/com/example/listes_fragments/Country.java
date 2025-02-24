package com.example.listes_fragments;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private String capital;
    private int flagResource; // Image du drapeau
    private String population;
    private String region;

    public Country(String name, String capital, int flagResource, String population, String region) {
        this.name = name;
        this.capital = capital;
        this.flagResource = flagResource;
        this.population = population;
        this.region = region;
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

    public String getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }
}