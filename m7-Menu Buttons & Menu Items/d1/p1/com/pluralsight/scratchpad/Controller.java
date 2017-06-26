package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane background;

    @FXML
    private MenuButton list;

    @FXML
    void onChange(ActionEvent event) {
        System.out.println("Selected: " + event.getSource());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
