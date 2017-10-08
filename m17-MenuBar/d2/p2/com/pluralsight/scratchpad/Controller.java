package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    Clipboard systemClipboard = Clipboard.getSystemClipboard();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void onCopy(ActionEvent event) {
        ClipboardContent content = new ClipboardContent();
        String selectedText = log.getSelectedText();
        if (selectedText != null && !selectedText.equals("")) {
            content.putString(selectedText);
        } else {
            content.putString(log.getText());
        }
        systemClipboard.setContent(content);
    }

    @FXML
    void onCut(ActionEvent event) {
        ClipboardContent content = new ClipboardContent();
        String selectedText = log.getSelectedText();
        if (selectedText != null && !selectedText.equals("")) {
            content.putString(selectedText);
            log.replaceText(log.getSelection(), "");
            log.getSelection();
        } else {
            content.putString(log.getText());
            log.clear();
        }
        systemClipboard.setContent(content);
    }

    @FXML
    void onPaste(ActionEvent event) {
        log.appendText(systemClipboard.getString());
    }

    @FXML
    void onClear(ActionEvent event) {
        log.clear();
    }

    @FXML
    void toUpper(ActionEvent event) {
        log.setText(log.getText().toUpperCase());
    }

    @FXML
    void onClick(ActionEvent event) {
        log("Clicked");
    }

}
