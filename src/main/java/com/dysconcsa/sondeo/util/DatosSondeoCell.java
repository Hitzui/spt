package com.dysconcsa.sondeo.util;

import com.dysconcsa.sondeo.model.DatosSondeo;
import com.dysconcsa.sondeo.views.AppViewManager;
import com.dysconcsa.sondeo.views.DatosSondeoPresenter;
import com.gluonhq.charm.glisten.control.CharmListCell;
import com.gluonhq.charm.glisten.control.Dialog;
import com.gluonhq.charm.glisten.control.ListTile;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DatosSondeoCell extends CharmListCell<DatosSondeo> {
    private final ListTile tile = new ListTile();
    private DatosSondeo currentItem;
    private final DateTimeFormatter dateFormat;

    public DatosSondeoCell() {
        tile.setPrimaryGraphic(MaterialDesignIcon.DESCRIPTION.graphic());

        var btnEdit = MaterialDesignIcon.EDIT.button();
        btnEdit.setOnAction(e -> {
            var x = AppViewManager.DATOS_SONDEO;
            if(x.getPresenter().isPresent()){
                var presenter = (DatosSondeoPresenter) x.getPresenter().get();
                presenter.setData(currentItem);
                x.switchView();
            }
        });
        var btnRemove = MaterialDesignIcon.DELETE.button();
        btnRemove.setOnAction(e->{
            var dialog = new Dialog<>();
            dialog.setTitle(new Label("Eliminar"));
            dialog.setContentText("Seguro desea eliminar el valor seleccionado? Esta accion no se puede revertir");
            var btn1 = new Button("Aceptar");
            var btn2 = new Button("Cancelar");
            dialog.getButtons().addAll(btn1,btn2);
            btn1.setOnAction(e1->{
                Variables.getInstance().datosSondeoObservableList.remove(currentItem);
                dialog.hide();
            });
            btn2.setOnAction(e1->dialog.hide());
            dialog.showAndWait();
        });
        var buttonBar = new HBox(0, btnEdit, btnRemove);
        buttonBar.setAlignment(Pos.CENTER_RIGHT);

        tile.setSecondaryGraphic(buttonBar);
        this.dateFormat = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy - HH:mm", Locale.ENGLISH);
    }

    @Override
    public void updateItem(DatosSondeo item, boolean empty) {
        super.updateItem(item, empty);
        currentItem = item;
        if (!empty && item != null) {
            tile.textProperty().setAll(item.getSondeoNumero(), item.getUbicacion());
            setGraphic(tile);
        } else {
            setGraphic(null);
        }
    }

}
