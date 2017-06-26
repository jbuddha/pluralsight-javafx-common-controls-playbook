package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ButtonBar bar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button yesButton = new Button("Yes");
        bar.setButtonData(yesButton, ButtonBar.ButtonData.YES);

        Button noButton = new Button("No");
        bar.setButtonData(yesButton, ButtonBar.ButtonData.NO);

        Button cancelButton = new Button("Cancel");
        bar.setButtonData(cancelButton, ButtonBar.ButtonData.CANCEL_CLOSE);
        bar.getButtons().addAll(yesButton, noButton, cancelButton);
    }

    @FXML
    void onClick(ActionEvent event) {
        log("Clicked " + ((Button)event.getTarget()).getText());
    }

    @FXML
    void onClose(ActionEvent event) {
        System.exit(0);
    }

}
