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
//        yearSpinner.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
        yearSpinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
    }

}
