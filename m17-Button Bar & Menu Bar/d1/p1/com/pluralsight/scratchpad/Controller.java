package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void onClick(ActionEvent event) {
        log("Clicked " + ((Button)event.getTarget()).getText());
    }

    @FXML
    void onClose(ActionEvent event) {
        System.exit(0);
    }

}
