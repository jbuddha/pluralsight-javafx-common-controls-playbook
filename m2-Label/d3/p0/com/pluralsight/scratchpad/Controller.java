package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

import static com.pluralsight.scratchpad.FontUtils.getRandomFont;

public class Controller implements Initializable {

    @FXML
    private Label dynamicLabel;

    @FXML
    private Label anotherLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dynamicLabel.setText("Dynamic Label");
        Font font = getRandomFont(45);
        dynamicLabel.setFont(font);
        anotherLabel.setText("Another Label");
        anotherLabel.setFont(getRandomFont(35));
        anotherLabel.setOnMouseClicked(event -> {
            Font f = anotherLabel.getFont();
            anotherLabel.setFont(new Font(f.getName(), f.getSize()+5));
        });
    }

    @FXML
    void mouseIn(MouseEvent event) {
        Font f = dynamicLabel.getFont();
        dynamicLabel.setFont(new Font(f.getName(), f.getSize()+10));
        dynamicLabel.setStyle("-fx-text-fill: blue;");
    }

    @FXML
    void mouseOut(MouseEvent event) {
        Font f = dynamicLabel.getFont();
        dynamicLabel.setFont(new Font(f.getName(), f.getSize()-10));
    }


    @FXML
    void addDropShadow(MouseEvent event) {
        anotherLabel.setEffect(new DropShadow(15, -5, -5, Color.BLUE));
        anotherLabel.setCursor(Cursor.CROSSHAIR);
    }

    @FXML
    void removeDropShadow(MouseEvent event) {
        //anotherLabel.setStyle("-fx-effect: none");
        anotherLabel.setEffect(null);
    }
}
