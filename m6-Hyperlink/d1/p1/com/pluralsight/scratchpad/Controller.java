package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label logLabel;

    @FXML
    private Hyperlink imagedLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imagedLabel.setGraphic(getImageView("happy-green.png"));
        imagedLabel.setOnAction(event -> {
            logLabel.setText(logLabel.getText() + "Clicked: " +
                             ((Hyperlink)event.getSource()).getText() + System.lineSeparator());
            imagedLabel.setVisited(false);
            logLabel.setText(logLabel.getText() + "Unvisited: " +
                             ((Hyperlink)event.getSource()).getText() + System.lineSeparator());
        });
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
    void onClick(ActionEvent event) {
        logLabel.setText(logLabel.getText() + "Clicked: " +
                         ((Hyperlink)event.getSource()).getText() + System.lineSeparator());
    }
}
