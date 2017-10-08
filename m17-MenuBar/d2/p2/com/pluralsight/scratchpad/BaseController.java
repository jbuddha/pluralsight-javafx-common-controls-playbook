package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public abstract class BaseController implements Initializable {

    @FXML
    protected TextArea log;

    protected void log(Object line) {
        log.appendText(line.toString() + System.lineSeparator());
    }
}
