package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
        //datePicker.setChronology(JapaneseChronology.INSTANCE);
        datePicker.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate object) {
                if(object == null)
                    return null;
                return object.format(DateTimeFormatter.ofPattern("MMM dd"));
            }

            @Override
            public LocalDate fromString(String string) {
                return LocalDate.parse(string, DateTimeFormatter.ofPattern("MMM dd"));
            }
        });
    }

    @FXML
    void onChange(ActionEvent event) {
        log(datePicker.getValue());
        log(datePicker.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));
    }

}
