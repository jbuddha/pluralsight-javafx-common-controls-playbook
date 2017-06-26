package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<Continent> continentListView;

    private ObservableList<Continent> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(FXCollections.observableArrayList("Asia", "Europe", "Africa"));

        list.addAll(new Continent("Asia", 100000),
                    new Continent("Europe", 10000),
                    new Continent("Africa", 10000),
                    new Continent("Australia", 10000),
                    new Continent("North America", 10000));

        continentListView.setItems(list);
    }

}
