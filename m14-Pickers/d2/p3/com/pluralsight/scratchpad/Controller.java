package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tooltip;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private DatePicker datePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if(item.isBefore(LocalDate.now().plusDays(1)) || item.isAfter(LocalDate.now().plusWeeks(1))) {
                            setDisable(true);
                            setText("*");
                            setTooltip(new Tooltip("You should try in next one week"));
                        }
                    }
                };
            }
        });
    }

    @FXML
    void onChange(ActionEvent event) {
        log(datePicker.getValue());
        log(datePicker.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));
    }

}
