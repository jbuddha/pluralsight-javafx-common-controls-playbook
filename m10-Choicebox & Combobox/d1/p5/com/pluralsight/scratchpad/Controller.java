package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ChoiceBox<Continent> choiceBox;

    @FXML
    private TextField itemText;

    @FXML
    private Button addButton;

    ObservableList<Continent> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableArrayList();

        choiceBox.setItems(list);
        list.addAll(new Continent("Asia", 100000),
                    new Continent("Europe", 10000));

        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            log("Changed first choice box " + newValue);
            log(choiceBox.getValue());
        });
        
        addButton.disableProperty().bind(itemText.lengthProperty().lessThan(1));
        choiceBox.setConverter(new StringConverter<Continent>() {
            @Override
            public String toString(Continent continent) {
                return continent.getName();
            }

            @Override
            public Continent fromString(String string) {
                // not necessary for a choice box
                return null;
            }
        });
    }


    @FXML
    void onAdd(ActionEvent event) {
        list.add(new Continent(itemText.getText(), 100));
        itemText.clear();
    }
}
