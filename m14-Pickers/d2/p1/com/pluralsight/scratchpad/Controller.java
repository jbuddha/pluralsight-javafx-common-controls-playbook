package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private DatePicker datePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());
    }

    @FXML
    void onChange(ActionEvent event) {
        log(datePicker.getValue());
        log(datePicker.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));
    }

}
