package com.pluralsight.scratchpad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable {

    @FXML
    private TextArea log;

    @FXML
    private HTMLEditor htmlEditor;

    Random rand = new Random();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToolBar topToolbar = (ToolBar) htmlEditor.lookup(".top-toolbar");
        Button ourButton = new Button("Colorify");
        ourButton.setOnAction(event -> {
            colorify();
        });
        topToolbar.getItems().add(ourButton);
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

    void colorify() {
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);

        String gHex = Integer.toHexString(green);
        String rHex = Integer.toHexString(red);
        String bHex = Integer.toHexString(blue);

        String hex = "#" + rHex + gHex + bHex;

        String ans = htmlEditor.getHtmlText().replace("<body ", "<body bgcolor=\""+hex+"\"");
        htmlEditor.setHtmlText(ans);
    }

    @FXML
    void getCleanTextClick(ActionEvent event) {
        log.setText(getText(htmlEditor.getHtmlText()));
    }

    private void log(String line) {
        log.setText(log.getText() + line + System.lineSeparator());
    }
}
