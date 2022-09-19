package com.dysconcsa.sondeo.util;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFColor;

public class Util {

    public static String getHexColor(Color color){
        return "#" + color.toString().substring(2, 8);
    }
    public void loadColors(ObservableList<IndexedColors> itemsColorPoperties) {
        for (IndexedColors colors : IndexedColors.values()) {
            try {
                XSSFColor color = new XSSFColor(colors, null);
                if (!color.getARGBHex().equals("null")) {
                    itemsColorPoperties.add(colors);
                }
            } catch (Exception ignored) {
            }
        }

    }
}
