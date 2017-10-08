package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private MenuBar menuBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Menu menu = new Menu("My Menu");
        Menu levelOneMenu = new Menu("Level One");
        MenuItem item = new MenuItem("My Item");
        MenuItem item2 = new MenuItem("My Item2");
        item.setOnAction(event -> {
            log("Custom menu item is clicked");
        });
        levelOneMenu.getItems().addAll(item, new SeparatorMenuItem(), item2);
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
