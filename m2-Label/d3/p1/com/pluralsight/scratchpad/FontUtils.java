package com.pluralsight.scratchpad;

import javafx.scene.text.Font;

import java.util.List;
import java.util.Random;

public class FontUtils {
    private static List<String> fonts = Font.getFontNames();

    private static Random r = new Random();

    public static String getRandomFont() {
        return fonts.get(r.nextInt(fonts.size()));
    }

    public static Font getRandomFont(int size) {
        return new Font(getRandomFont(), size);
    }
}
