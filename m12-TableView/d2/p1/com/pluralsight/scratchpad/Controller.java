package com.pluralsight.scratchpad;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
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
import java.util.concurrent.Callable;

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

    Country country;

    SimpleObjectProperty<Country> countryUnderEdit = new SimpleObjectProperty<>(null);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        country = new Country("Germany", 100, "German");
        countriesList.add(new Country("India", 100, "Hindi"));
        countriesList.add(new Country("France", 10, "French"));
        countriesList.add(country);

        table.setItems(countriesList);

        nameColumn.setCellValueFactory(item -> item.getValue().getNameProperty());
        populationColumn.setCellValueFactory(item -> item.getValue().getPopulationProperty().asString());
        languageColumn.setCellValueFactory(item -> item.getValue().getLanguageProperty());

        addButton.disableProperty().bind(Bindings.and(nameTextField.lengthProperty().lessThan(1),
                                                      populationTextField.lengthProperty().lessThan(1)));

        table.getSelectionModel().getSelectedItems().addListener((ListChangeListener<? super Country>)  observable -> {
            log(observable.getList());
            countryUnderEdit.set(observable.getList().get(0));
            nameTextField.setText(countryUnderEdit.get().getName());
            populationTextField.setText(countryUnderEdit.get().getPopulation().toString());
            languageTextField.setText(countryUnderEdit.get().getLanguage().toString());
        });

        removeButton.disableProperty().bind(Bindings.isNull(countryUnderEdit));
        addButton.textProperty().bind(Bindings.when(countryUnderEdit.isNull()).then("Add").otherwise("Update"));
    }

    @FXML
    private void onAddClick(ActionEvent event) {
        if (countryUnderEdit.get() == null) {
            countriesList.add(new Country(nameTextField.getText(),
                Integer.parseInt(populationTextField.getText()),
                languageTextField.getText()));
        } else {
            countryUnderEdit.get().setName(nameTextField.getText());
            countryUnderEdit.get().setPopulation(Integer.parseInt(populationTextField.getText()));
            countryUnderEdit.get().setLanguage(languageTextField.getText());
        }
        nameTextField.clear();
        populationTextField.clear();
        languageTextField.clear();
        countryUnderEdit.set(null);
    }

}
