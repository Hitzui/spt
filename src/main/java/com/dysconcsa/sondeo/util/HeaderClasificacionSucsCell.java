package com.dysconcsa.sondeo.util;

import com.dysconcsa.sondeo.model.ClasificacionSucsProperty;
import com.gluonhq.charm.glisten.control.CharmListCell;
import javafx.scene.control.Label;

public class HeaderClasificacionSucsCell extends CharmListCell<ClasificacionSucsProperty> {
    private final Label label;
    private ClasificacionSucsProperty currentItem;

    public HeaderClasificacionSucsCell() {
        label = new Label();
    }

    @Override
    public void updateItem(ClasificacionSucsProperty item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty && item != null) {
            update();
            setGraphic(label);
        } else {
            setGraphic(null);
        }
    }

    private void update() {
        if (currentItem != null) {
            label.setText(currentItem.getDescripcion());
        } else {
            label.setText("");
        }
    }
}
