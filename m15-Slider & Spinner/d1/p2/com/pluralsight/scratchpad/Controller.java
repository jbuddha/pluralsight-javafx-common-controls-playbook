package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private Slider yearSlider;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yearSlider.setOrientation(Orientation.VERTICAL);
        yearSlider.setMin(2000);
        yearSlider.setMax(2015);
        yearSlider.setShowTickLabels(true);
        yearSlider.setShowTickMarks(true);

        yearSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                return object.intValue()%5 == 0 ? object.intValue() + "" : "" + object.intValue() % 1000;
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
    }

}
