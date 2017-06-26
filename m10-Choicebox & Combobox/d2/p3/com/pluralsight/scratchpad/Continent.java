package com.pluralsight.scratchpad;

public class Continent {
    private String name;
    private Double population;

    public Continent(String name, double population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return name + " - " + population;
    }
}
