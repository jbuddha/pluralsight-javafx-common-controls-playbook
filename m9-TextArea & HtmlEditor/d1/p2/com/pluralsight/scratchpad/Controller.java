package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea log;

    @FXML
    private HTMLEditor htmlEditor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    void onClick(ActionEvent event) {
        log.setText(htmlEditor.getHtmlText());
    }

    private void log(String line) {
        log.setText(log.getText() + line + System.lineSeparator());
    }
}
