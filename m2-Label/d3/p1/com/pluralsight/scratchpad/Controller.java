package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

import static com.pluralsight.scratchpad.FontUtils.getRandomFont;

public class Controller implements Initializable {

    @FXML
    private Label dynamicLabel;

    @FXML
    private Label anotherLabel;

    @FXML
    private Label imagedLabel;

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
        Image image = new Image(getClass().getResourceAsStream("happy.png"), 50, 50, true, true);
        ImageView view = new ImageView(image);
        imagedLabel.setGraphic(view);
        imagedLabel.setText("This is happy face");
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
        anotherLabel.setCursor(Cursor.CROSSHAIR);
    }

    @FXML
    void removeDropShadow(MouseEvent event) {
        anotherLabel.setEffect(null);
    }
}
