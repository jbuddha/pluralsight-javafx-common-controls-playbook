package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button defaultButton;

    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        defaultButton.setGraphic(getImageView("happy-green.png"));
        cancelButton.setGraphic(getImageView("sad-orange.png"));
    }

    private ImageView getImageView(String name) {
        Image orangeImage = new Image(getClass().getResourceAsStream(name),
                                      50,
                                      50,
                                      true,
                                      true);
        return new ImageView(orangeImage);
    }

    @FXML
    void handleDefaultButton(ActionEvent event) {
        System.out.println("Default Button clicked");
    }

    @FXML
    void handleCancelButton(ActionEvent event) {
        System.out.println("Cancel Button clicked");
    }
}
