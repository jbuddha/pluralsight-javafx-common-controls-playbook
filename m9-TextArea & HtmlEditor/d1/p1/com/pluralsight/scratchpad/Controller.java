package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label log;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    private void log(String line) {
        log.setText(log.getText() + line + System.lineSeparator());
    }
}
