package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onClick(ActionEvent event) {
        log(((MenuItem)event.getTarget()).getText());
    }

    @FXML
    private void onClose(ActionEvent event) {
        System.exit(0);
    }
}
