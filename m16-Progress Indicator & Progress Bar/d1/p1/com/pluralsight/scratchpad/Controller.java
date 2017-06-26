package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    ProgressIndicator progress;

    @FXML
    private Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void onStart(ActionEvent event) {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(250);
                progress.setProgress(i/10.0);
            } catch (InterruptedException e) {

            }
        }
    }

}
