package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private AnchorPane base;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colorPicker.setValue(Color.ALICEBLUE);
//        colorPicker.setStyle("-fx-color-label-visible: false");
//        colorPicker.getStyleClass().add(ColorPicker.STYLE_CLASS_BUTTON);
        colorPicker.getStyleClass().add(ColorPicker.STYLE_CLASS_SPLIT_BUTTON);
    }

    @FXML
    void onColorChange(ActionEvent event) {
        System.out.println(colorPicker.getValue());
        Background bg = new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY));
        base.setBackground(bg);
    }

}
