package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<Continent> continentListView;

    @FXML
    private TextField filterTextField;

    @FXML
    private ChoiceBox<String> fieldCombo;

    @FXML
    private Button ascButton;

    @FXML
    private Button descButton;

    private ObservableList<Continent> list = FXCollections.observableArrayList();

    private FilteredList<Continent> filteredList = new FilteredList<Continent>(list);

    private SortedList<Continent> sortedList = new SortedList<Continent>(list);

    private ObservableList<String> continents = FXCollections.observableArrayList("Asia", "Europe", "Africa");

    private ObservableList<String> fields = FXCollections.observableArrayList("Name", "Population");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(continents);

        list.addAll(new Continent("Asia", 100000),
                    new Continent("Europe", 10000),
                    new Continent("Africa", 10000),
                    new Continent("Australia", 10000),
                    new Continent("North America", 10000));

        continentListView.setItems(sortedList);

        fieldCombo.setItems(fields);

        ascButton.disableProperty().bind(fieldCombo.valueProperty().isNull());
        descButton.disableProperty().bind(fieldCombo.valueProperty().isNull());

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

    @FXML
    void onAscending(ActionEvent event) {
        sortedList.setComparator(new Comparator<Continent>() {
            @Override
            public int compare(Continent o1, Continent o2) {
                String field = fieldCombo.getValue();
                if (field.equals("Name")) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return o1.getPopulation().compareTo(o2.getPopulation());
                }
            }
        });
    }

    @FXML
    void onDescending(ActionEvent event) {
        sortedList.setComparator(new Comparator<Continent>() {
            @Override
            public int compare(Continent o1, Continent o2) {
                String field = fieldCombo.getValue();
                if (field.equals("Name")) {
                    return -1 * o1.getName().compareTo(o2.getName());
                } else {
                    return -1 * o1.getPopulation().compareTo(o2.getPopulation());
                }
            }
        });
    }

    @FXML
    private void filter(ActionEvent event) {
        filteredList.setPredicate(continent -> {
            return continent.toString().contains(filterTextField.getText());
        });
    }

}
