package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

import static com.pluralsight.scratchpad.FontUtils.getRandomFont;

public class Controller implements Initializable {

    @FXML
    private Label dynamicLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dynamicLabel.setText("Dynamic Label");
        Font font = getRandomFont(45);
        dynamicLabel.setFont(font);
    }

    @FXML
    void mouseIn(MouseEvent event) {
        Font f = dynamicLabel.getFont();
        dynamicLabel.setFont(new Font(f.getName(), f.getSize()+10));
        dynamicLabel.setTextFill(Paint.valueOf("#0000FF"));
    }

    @FXML
    void mouseOut(MouseEvent event) {
        Font f = dynamicLabel.getFont();
        dynamicLabel.setFont(new Font(f.getName(), f.getSize()-10));
        dynamicLabel.setTextFill(Paint.valueOf("#000000"));

    }

}
