package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ToggleGroup toggleGroupOne;

    @FXML
    private ToggleGroup toggleGroupTwo;

    @FXML
    private Toggle t1;

    @FXML
    private Toggle t2;

    @FXML
    private Toggle t3;

    @FXML
    private Label tgOneLabel;

    @FXML
    private Label t1Label;

    @FXML
    private Label t2Label;

    @FXML
    private Label t3Label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                t1Label.setText("Selected");
            } else {
                t1Label.setText("Deselected");
            }
        });

        t2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                t2Label.setText("Selected");
            } else {
                t2Label.setText("Deselected");
            }
        });

        t3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                t3Label.setText("Selected");
            } else {
                t3Label.setText("Deselected");
            }
        });

        toggleGroupOne.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                tgOneLabel.setText("Nothing");
            } else {
                tgOneLabel.setText(((ToggleButton)newValue).getText());
            }
         });
    }
}
