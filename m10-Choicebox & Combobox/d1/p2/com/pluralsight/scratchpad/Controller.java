package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList();

        choiceBox.setItems(list);
        list.addAll("Asia", "Europe", "Africa", "North America", "South America", "Australia");

        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            log("Changed first choice box" + newValue);
        });
    }


    @FXML
    void onAction(ActionEvent event) {
        // this doesn't work as ChoiceBox doesn't have onAction method
        log("Continent changed to " + choiceBox.getValue());
    }
}
