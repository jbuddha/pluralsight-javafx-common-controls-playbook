package com.pluralsight.scratchpad;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    ProgressIndicator progress;

    @FXML
    ProgressBar progressBar;

    @FXML
    private Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void onStart(ActionEvent event) {
        progress.setVisible(true);
        progressBar.setVisible(true);
        Task t = new Task() {
            @Override
            protected Object call() throws Exception {
                for(int i = 0; i <= 10; i++) {
                    updateProgress(i/10.0, 1);
                    Thread.sleep(250);
                }
                return null;
            }
        };

        t.setOnSucceeded(e -> {
            log("Task is done");
            progress.setVisible(false);
            progressBar.setVisible(false);
        });
        progress.progressProperty().bind(t.progressProperty());
        progressBar.progressProperty().bind(t.progressProperty());

        new Thread(t).start();
    }

}
