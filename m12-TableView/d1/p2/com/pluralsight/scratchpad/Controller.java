package com.pluralsight.scratchpad;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML private TableView<Country> table;

    @FXML private TableColumn<Country, String> nameColumn;
    @FXML private TableColumn<Country, String> populationColumn;
    @FXML private TableColumn<Country, String> languageColumn;

    @FXML private TextField nameTextField;
    @FXML private TextField populationTextField;
    @FXML private TextField languageTextField;

    @FXML private Button addButton;
    @FXML private Button removeButton;

    ObservableList<Country> countriesList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        countriesList.add(new Country("India", 100, "Hindi"));
        countriesList.add(new Country("France", 10, "French"));
        countriesList.add(new Country("Germany", 100, "German"));

        table.setItems(countriesList);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("Population"));
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("Language"));

        addButton.disableProperty().bind(Bindings.and(nameTextField.lengthProperty().lessThan(1),
                                                      populationTextField.lengthProperty().lessThan(1)));

        table.getSelectionModel().getSelectedItems().addListener((ListChangeListener<? super Country>)  observable -> {
            log(observable.getList());
        });
    }

    @FXML
    private void onAddClick(ActionEvent event) {
        countriesList.add(new Country(nameTextField.getText(),
                                      Integer.parseInt(populationTextField.getText()),
                                      languageTextField.getText()));
        nameTextField.clear();
        populationTextField.clear();
        languageTextField.clear();
    }

}
