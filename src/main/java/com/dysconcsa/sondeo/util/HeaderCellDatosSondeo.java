package com.dysconcsa.sondeo.util;


import com.dysconcsa.sondeo.model.DatosSondeo;
import com.gluonhq.charm.glisten.control.CharmListCell;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HeaderCellDatosSondeo extends CharmListCell<DatosSondeo> {
    private final Label label;
    private DatosSondeo currentItem;
    private final DateTimeFormatter dateFormat;

    public HeaderCellDatosSondeo() {
        label = new Label();
        dateFormat = DateTimeFormatter.ofPattern("EEEE, MMM dd", Locale.ENGLISH);
    }

    @Override
    public void updateItem(DatosSondeo item, boolean empty) {
        super.updateItem(item, empty);
        currentItem = item;
        if (!empty && item != null) {
            update();
            setGraphic(label);
        } else {
            setGraphic(null);
        }
    }

    private void update() {
        if (currentItem != null) {
            label.setText(dateFormat.format(currentItem.getFechaInicio()));
        } else {
            label.setText("");
        }
    }
}
