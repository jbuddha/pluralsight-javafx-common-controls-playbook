package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static com.pluralsight.scratchpad.FontUtils.getRandomFont;

public class Controller implements Initializable {

    @FXML
    private Label dynamicLabel;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dynamicLabel.setText("Dynamic Label");
        dynamicLabel.setFont(getRandomFont(45));
    }


}
