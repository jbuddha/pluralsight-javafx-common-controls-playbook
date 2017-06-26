package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<Continent> continentListView;

    private ObservableList<Continent> list = FXCollections.observableArrayList();

    private ObservableList<String> continents = FXCollections.observableArrayList("Asia", "Europe", "Africa");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(continents);

        list.addAll(new Continent("Asia", 100000),
                    new Continent("Europe", 10000),
                    new Continent("Africa", 10000),
                    new Continent("Australia", 10000),
                    new Continent("North America", 10000));

        continentListView.setItems(list);

        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        continentListView.setEditable(true);
        continentListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<Continent>() {
            @Override
            public String toString(Continent object) {
                if(object != null)
                    return object.getName();
                else
                    return "";
            }

            @Override
            public Continent fromString(String string) {
                if(string != null)
                    return new Continent(string, 100);
                else
                    return null;
            }
        }));

        listView.getSelectionModel().getSelectedItems().addListener((ListChangeListener)observable -> {
            log(observable.getList());
        });
    }

}
