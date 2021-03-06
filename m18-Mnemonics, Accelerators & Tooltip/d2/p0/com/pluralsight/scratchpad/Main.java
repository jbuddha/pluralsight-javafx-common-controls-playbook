package com.pluralsight.scratchpad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("base.fxml"));
        primaryStage.setTitle("Controls Scratch Pad");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);

        KeyCombination hideKey = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
        Runnable task = () -> scene.getWindow().centerOnScreen();
        scene.getAccelerators().put(hideKey, task);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
