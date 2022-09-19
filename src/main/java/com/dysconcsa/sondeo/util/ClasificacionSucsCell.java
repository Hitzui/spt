package com.dysconcsa.sondeo.util;

import com.dysconcsa.sondeo.model.ClasificacionSucsProperty;
import com.gluonhq.charm.glisten.control.CharmListCell;
import com.gluonhq.charm.glisten.control.ListTile;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.function.Consumer;

public class ClasificacionSucsCell extends CharmListCell<ClasificacionSucsProperty> {
    private final ListTile tile = new ListTile();
    private ClasificacionSucsProperty currentItem;

    public ClasificacionSucsCell(Consumer<ClasificacionSucsProperty> edit, Consumer<ClasificacionSucsProperty> remove) {
        tile.setPrimaryGraphic(MaterialDesignIcon.DESCRIPTION.graphic());
        var btnEdit = MaterialDesignIcon.EDIT.button(e -> edit.accept(currentItem));
        var btnRemove = MaterialDesignIcon.DELETE.button(e -> remove.accept(currentItem));
        var buttonBar = new HBox(0, btnEdit, btnRemove);
        buttonBar.setAlignment(Pos.CENTER_RIGHT);

        tile.setSecondaryGraphic(buttonBar);
    }

    @Override
    public void updateItem(ClasificacionSucsProperty item, boolean empty) {
        super.updateItem(item, empty);
        currentItem = item;
        if (!empty && item != null) {
            tile.textProperty().setAll(String.valueOf(item.getProfundidad()), item.getDescripcion());
            setGraphic(tile);
        } else {
            setGraphic(null);
        }
    }
}
