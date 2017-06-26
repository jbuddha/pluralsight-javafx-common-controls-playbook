package com.pluralsight.scratchpad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class Controller implements Initializable {

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField numericTextField;

    @FXML
    private TextField phoneNumber;

    @FXML
    private PasswordField password;

    @FXML
    private TextField passwordText;

    @FXML
    private CheckBox showCharactersCheckBox;

    @FXML
    private Label log;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField1.setOnAction(event -> {
            log.setText(log.getText() + System.lineSeparator() + "Text Field 1: Action Performed");
        });

        textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                log.setText(log.getText() + System.lineSeparator() + "Text Field 1: Gained Focus");
            else
                log.setText(log.getText() + System.lineSeparator() + "Text Field 1: Lost Focus");
        });
        textField2.disableProperty().bind(textField1.textProperty().length().lessThan(1));

        numericTextField.setTextFormatter(getNumericOnlyFormatter());

        phoneNumber.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {

            @Override
            public String toString(String string)
            {
                if (string == null)
                    return "";
                return string.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
            }

            @Override
            public String fromString(String object)
            {
                if (object == null)
                    return "";
                return object.replace("\\(|\\)|\\-","");

            }
        }));

        phoneNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            log.setText(log.getText() + System.lineSeparator() + "Formatted text's new value: " + newValue);
        });

        password.visibleProperty().bind(passwordText.visibleProperty().not());
        passwordText.visibleProperty().bind(showCharactersCheckBox.selectedProperty());
        passwordText.textProperty().bindBidirectional(password.textProperty());
    }

    private TextFormatter<String> getNumericOnlyFormatter() {
        return new TextFormatter<String>(new UnaryOperator<Change>() {
            @Override
            public Change apply(Change change) {
                change.setText(change.getText().replaceAll("[^0-9]", ""));
                return change;
            }
        });
    }
}
