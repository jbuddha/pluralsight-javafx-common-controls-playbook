package com.pluralsight.scratchpad;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.junit.Test;

public class ObservableListTests {
    @Test
    public void listTest() {
        ObservableList<String> list = FXCollections.observableArrayList();

        list.add("Hello");

        list.add("World");

        list.addListener((ListChangeListener<? super String>)  change -> {
            System.out.println(change);
        });

        list.add("JavaFX");
        list.add("is");
        list.add("Best");

    }


}
