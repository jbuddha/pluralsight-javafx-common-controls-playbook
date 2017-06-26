package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private Toggle maleToggle;

    @FXML
    private Toggle femaleToggle;

    @FXML
    private Toggle otherToggle;

    @FXML
    private Label dataLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maleToggle.setUserData("M");
        femaleToggle.setUserData("F");
        otherToggle.setUserData("O");

        genderGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                dataLabel.setText(newValue.getUserData().toString());
            }
        });
    }
}
