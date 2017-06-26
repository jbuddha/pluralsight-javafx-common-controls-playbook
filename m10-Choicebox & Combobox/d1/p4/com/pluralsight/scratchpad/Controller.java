package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField itemText;

    @FXML
    private Button addButton;

    ObservableList<String> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableArrayList();

        choiceBox.setItems(list);
        list.addAll("Asia", "Europe", "Africa", "North America", "South America", "Australia");

        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            log("Changed first choice box " + newValue);
        });

        addButton.disableProperty().bind(itemText.lengthProperty().lessThan(1));
    }


    @FXML
    void onAdd(ActionEvent event) {
        list.add(itemText.getText());
        itemText.clear();
    }
}
