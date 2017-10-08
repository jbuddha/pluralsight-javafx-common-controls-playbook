package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstNameLabel.setLabelFor(firstNameTextField);
        lastNameLabel.setLabelFor(lastNameTextField);
    }


    @FXML
    void onNext(ActionEvent event) {
        log("Clicked Next");
    }

    @FXML
    void onPrevious(ActionEvent event) {
        log("Clicked Previous");
    }


}
