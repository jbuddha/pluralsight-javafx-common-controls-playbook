package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private Spinner<Integer> yearSpinner;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yearSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2000, 2015, 1));
        yearSpinner.getEditor().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    yearSpinner.increment(1);
                    break;
                case DOWN:
                    yearSpinner.decrement(1);
                    break;
            }
        });
    }

}
