package com.pluralsight.scratchpad;

public class Country {
    private String name;
    private Integer population;
    private String language;

    public Country(String name, Integer population, String language) {
        this.name = name;
        this.population = population;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
