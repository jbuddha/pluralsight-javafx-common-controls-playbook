package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Label log;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField1.setOnAction(event -> {
            log.setText(log.getText() + System.lineSeparator() + "Text Field 1: Action Performed");
        });

        textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                log.setText(log.getText() + System.lineSeparator() + "Text Field 1: Gained Focus");
            else
                log.setText(log.getText() + System.lineSeparator() + "Text Field 1: Lost Focus");
        });
        textField2.disableProperty().bind(textField1.textProperty().length().lessThan(1));
    }
}
