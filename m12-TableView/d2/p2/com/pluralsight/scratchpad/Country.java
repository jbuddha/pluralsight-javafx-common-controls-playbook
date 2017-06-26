package com.pluralsight.scratchpad;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Country {
    private SimpleStringProperty name;
    private SimpleIntegerProperty population;
    private SimpleStringProperty language;

    public Country(String name, Integer population, String language) {
        this.name = new SimpleStringProperty(name);
        this.population = new SimpleIntegerProperty(population);
        this.language = new SimpleStringProperty(language);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Integer getPopulation() {
        return population.get();
    }

    public void setPopulation(Integer population) {
        this.population.set(population);
    }

    public IntegerProperty getPopulationProperty() {
        return population;
    }

    public String getLanguage() {
        return language.get();
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    public StringProperty getLanguageProperty() {
        return language;
    }

    @Override
    public String toString() {
        return name + " - " + population + " - " + language;
    }
}
