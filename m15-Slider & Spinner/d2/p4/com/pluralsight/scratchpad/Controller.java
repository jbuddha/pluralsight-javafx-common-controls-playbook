package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private Spinner<String> yearSpinner;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        yearSpinner.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
//        yearSpinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
        yearSpinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        ObservableList<String> options = FXCollections.observableArrayList();
        for(int i = 0; i < 16; i++)
            options.add("Two Thousand + " + i);
        yearSpinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(options));
    }

}
