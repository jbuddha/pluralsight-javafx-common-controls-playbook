package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label dynamicLabel;

    private List<String> fonts = Font.getFontNames();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dynamicLabel.setText("Dynamic Label");

        Random r = new Random();

        dynamicLabel.setFont(new Font(fonts.get(r.nextInt(fonts.size())), 45));
    }
}
