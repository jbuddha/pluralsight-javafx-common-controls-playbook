package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private MenuBar menuBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Menu menu = new Menu("My Menu");
        Menu levelOneMenu = new Menu("Level One");
        MenuItem asiaItem = new MenuItem("Asia");
        MenuItem africaItem = new MenuItem("Africa");

        Image asiaImage = new Image(getClass().getResourceAsStream("Asia.png"));
        Image africaImage = new Image(getClass().getResourceAsStream("Africa.png"));

        ImageView asiaImageView = new ImageView(asiaImage);
        ImageView africaImageView = new ImageView(africaImage);

        asiaImageView.setFitWidth(25);
        africaImageView.setFitWidth(25);
        asiaImageView.setFitHeight(25);
        africaImageView.setFitHeight(25);

        asiaItem.setGraphic(asiaImageView);
        africaItem.setGraphic(africaImageView);

        CheckMenuItem checkMenuItem = new javafx.scene.control.CheckMenuItem()

        levelOneMenu.getItems().addAll(asiaItem, new SeparatorMenuItem(), africaItem);
        menu.getItems().add(levelOneMenu);
        menuBar.getMenus().add(menu);
    }

    @FXML
    private void onClick(ActionEvent event) {
        log(((MenuItem)event.getTarget()).getText());
    }

    @FXML
    private void onClose(ActionEvent event) {
        System.exit(0);
    }
}
