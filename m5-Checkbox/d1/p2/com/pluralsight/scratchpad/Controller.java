package com.pluralsight.scratchpad;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label selectedGamesLabel;

    @FXML
    private Label selectedCountLabel;

    private SimpleIntegerProperty count = new SimpleIntegerProperty(0);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedCountLabel.textProperty().bind(count.asString());
    }

    @FXML
    void changed(ActionEvent event) {
        CheckBox source = (CheckBox)event.getSource();
        if (source.isSelected()) {
            count.set(count.get() + 1);

        } else {
            count.set(count.get() - 1);
        }

    }
}
