package com.pluralsight.scratchpad;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

// TODO Implementing Initializable is required for scenebuilder to recognise it as Controller class
public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialized");
    }
}
