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
    void onNext(ActionEvent event) {
        log("Clicked Next");
    }

    @FXML
    void onPrevious(ActionEvent event) {
        log("Clicked Previous");
    }


}
