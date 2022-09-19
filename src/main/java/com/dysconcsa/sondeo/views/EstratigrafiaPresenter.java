package com.dysconcsa.sondeo.views;

import com.dysconcsa.sondeo.model.ClasificacionSucsProperty;
import com.dysconcsa.sondeo.model.Model;
import com.dysconcsa.sondeo.util.ClasificacionSucsCell;
import com.dysconcsa.sondeo.util.HeaderClasificacionSucsCell;
import com.dysconcsa.sondeo.util.Variables;
import com.gluonhq.charm.glisten.animation.FadeInLeftBigTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.Alert;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class EstratigrafiaPresenter implements Initializable {

    @Inject
    private Model model;
    @FXML
    public View view;
    @FXML
    public CharmListView<ClasificacionSucsProperty, Double> listEstratigrafia;
    private ClasificacionSucsProperty selectedValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listEstratigrafia.selectedItemProperty().addListener((observable, oldValue, newValue) -> selectedValue = newValue);
        listEstratigrafia.setItems(Variables.getInstance().clasificacionSucsObservableList);
        listEstratigrafia.setHeadersFunction(ClasificacionSucsProperty::getProfundidad);
        listEstratigrafia.setCellFactory(p -> new ClasificacionSucsCell(this::edit, this::remove));
        listEstratigrafia.setHeaderCellFactory(p -> new HeaderClasificacionSucsCell());
        listEstratigrafia.setPlaceholder(new Label("No se han agregado datos"));
        this.view.setShowTransitionFactory(FadeInLeftBigTransition::new);
        this.view.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        AppManager.getInstance().getDrawer().open()));
                appBar.setTitleText("Estratigrafia del Sondeo");
                //Si es Mobil usar la siguiente instruccion para editar un valor de campo
                appBar.getActionItems().add(MaterialDesignIcon.ADD_CIRCLE_OUTLINE.button((e) -> {
                    AppViewManager.EDIT_ESTRATIGRAFIA.switchView();
                }));
            }
        });
    }

    private void edit(ClasificacionSucsProperty clasificacionSucsProperty) {
        model.activeClasificacionSucsProperty().set(clasificacionSucsProperty);
        AppViewManager.EDIT_ESTRATIGRAFIA.switchView();
    }

    private void remove(ClasificacionSucsProperty clasificacionSucsProperty) {
        var alert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setContentText("Seguro desea eliminar el valor seleccionado?");
        alert.setTitleText("Eliminar");
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == ButtonType.OK) {
                Variables.getInstance().clasificacionSucsObservableList.remove(clasificacionSucsProperty);
            }
        });
    }
}
