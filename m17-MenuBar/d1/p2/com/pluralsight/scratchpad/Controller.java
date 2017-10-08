package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private MenuBar menuBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Menu menu = new Menu("My Menu");
        MenuItem item = new MenuItem("My Item");
        item.setOnAction(event -> {
            log("Custom menu item is clicked");
        });
        menu.getItems().add(item);
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
