package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ComboBox<Continent> comboBox;

    @FXML
    private TextField itemText;

    @FXML
    private Button addButton;

    ObservableList<Continent> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableArrayList();

        comboBox.setItems(list);
        list.addAll(new Continent("Asia", 100000),
                    new Continent("Europe", 10000),
                    new Continent("Africa", 10000),
                    new Continent("Australia", 10000),
                    new Continent("North America", 10000));

        comboBox.setEditable(true);
        comboBox.setVisibleRowCount(3);

        comboBox.setOnAction(event -> {
            log("Changed first choice box " + comboBox.getValue());
        });
        
        addButton.disableProperty().bind(itemText.lengthProperty().lessThan(1));
        comboBox.setConverter(new StringConverter<Continent>() {
            @Override
            public String toString(Continent continent) {
                if (continent != null)
                    return continent.getName();
                else
                    return "";
            }

            @Override
            public Continent fromString(String string) {
                if (string != null)
                    return new Continent(string, 100);
                else
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
