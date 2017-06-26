package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private ComboBox<Continent> comboBox;

    @FXML
    private ComboBox<String> priorityComboBox;

    @FXML
    private TextField itemText;

    @FXML
    private Button addButton;

    ObservableList<Continent> list;

    ObservableList<String> priorities;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableArrayList();
        priorities = FXCollections.observableArrayList("High", "Medium", "Low");

        prepareContinentCombo();
        preparePriorityCombo();
    }

    private void preparePriorityCombo() {
        priorityComboBox.setItems(priorities);
        priorityComboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                final ListCell<String> cell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if(item == null) {
                            setText(null);
                        } else {
                            setText(item);
                            if (item.contains("High")) {
                                setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5.0), Insets.EMPTY)));
                            } else if (item.contains("Medium")) {
                                setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5.0), Insets.EMPTY)));
                            } else {
                                setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5.0), Insets.EMPTY)));
                            }
                        }
                    }
                };

                return cell;
            }
        });
    }

    private void prepareContinentCombo() {
        comboBox.setItems(list);

        list.addAll(new Continent("Asia", 100000),
            new Continent("Europe", 10000),
            new Continent("Africa", 10000),
            new Continent("Australia", 10000),
            new Continent("North America", 10000));

        comboBox.setEditable(true);
        comboBox.setVisibleRowCount(3);

        comboBox.setOnAction(event -> {
            log("Changed first choice box " + comboBox.getValue());
        });

        addButton.disableProperty().bind(itemText.lengthProperty().lessThan(1));
        comboBox.setConverter(new StringConverter<Continent>() {
            @Override
            public String toString(Continent continent) {
                if (continent != null)
                    return continent.getName();
                else
                    return "";
            }

            @Override
            public Continent fromString(String string) {
                if (string != null)
                    return new Continent(string, 100);
                else
                    return null;
            }
        });
    }


    @FXML
    void onAdd(ActionEvent event) {
        list.add(new Continent(itemText.getText(), 100));
        itemText.clear();
    }
}
