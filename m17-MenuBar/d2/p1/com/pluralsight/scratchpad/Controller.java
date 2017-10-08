package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void onClear(ActionEvent event) {
        log.clear();
    }

    @FXML
    void toUpper(ActionEvent event) {
        log.setText(log.getText().toUpperCase());
    }

    @FXML
    void onClick(ActionEvent event) {
        log("Clicked");
    }

}
