package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable {

    @FXML
    private TextArea log;

    @FXML
    private HTMLEditor htmlEditor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    private String getText(String htmlText) {
        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(htmlText);
        final StringBuffer sb = new StringBuffer(htmlText.length());
        while(matcher.find()) {
            matcher.appendReplacement(sb, " ");
        }
        matcher.appendTail(sb);
        return sb.toString().trim();
    }

    @FXML
    void onClick(ActionEvent event) {
        log.setText(htmlEditor.getHtmlText());
    }

    @FXML
    void getCleanTextClick(ActionEvent event) {
        log.setText(getText(htmlEditor.getHtmlText()));
    }

    private void log(String line) {
        log.setText(log.getText() + line + System.lineSeparator());
    }
}
