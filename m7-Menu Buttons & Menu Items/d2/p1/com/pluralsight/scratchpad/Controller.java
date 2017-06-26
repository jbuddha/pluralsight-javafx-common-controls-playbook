package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane background;

    @FXML
    private MenuButton continents;

    @FXML
    private MenuButton countries;

    @FXML Label log;

    private Map<String, List<String>> countryMap = new HashMap<>();

    @FXML
    void onContinentChange(ActionEvent event) {
        continents.setText(((MenuItem)event.getSource()).getText());
        List<String> countriesOfAContinent = countryMap.get(continents.getText());
        countries.getItems().clear();
        for (String country: countriesOfAContinent) {
            countries.getItems().add(new MenuItem(country));
            countries.getItems().add(new SeparatorMenuItem());
        }
    }

    @FXML
    void onContinentClicked(ActionEvent event) {
        log.setText(log.getText() + System.lineSeparator() + "Clicked Continents Button");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        countryMap.put("Asia", Arrays.asList("India", "Pakistan", "China"));
        countryMap.put("Africa", Arrays.asList("Egypt", "South Africa", "Kenya"));
        countryMap.put("Australia", Arrays.asList("Australia", "New zealand"));
        countryMap.put("Europe", Arrays.asList("France", "Germany", "Switzerland"));
        countryMap.put("North America", Arrays.asList("Canada", "USA", "Mexico"));
        countryMap.put("South America", Arrays.asList("Brazil", "Chile"));


    }
}
