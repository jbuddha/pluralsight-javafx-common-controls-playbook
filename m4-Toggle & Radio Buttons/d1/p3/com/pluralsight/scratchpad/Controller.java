package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ToggleGroup toggleGroupOne;

    @FXML
    private ToggleGroup toggleGroupTwo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleGroupOne.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(((ToggleButton) newValue).getText());
            } else {
                System.out.println("All Toggles deselected");
            }
        });

        toggleGroupTwo.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(((ToggleButton) newValue).getText());
            } else {
                System.out.println("All Toggles deselected");
            }
        });
    }
}
