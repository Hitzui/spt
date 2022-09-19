package com.dysconcsa.sondeo.views;

import com.dysconcsa.sondeo.model.DatosSondeo;
import com.dysconcsa.sondeo.util.DatosSondeoCell;
import com.dysconcsa.sondeo.util.HeaderCellDatosSondeo;
import com.dysconcsa.sondeo.util.Variables;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.control.Dialog;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;
import java.time.LocalDate;

public class PrimaryPresenter {

    @Inject
    private DatosSondeoPresenter datosSondeoPresenter;
    @FXML
    public CharmListView<DatosSondeo, LocalDate> listView;
    @FXML
    private View primary;

    public void initialize() {
        listView.setItems(Variables.getInstance().datosSondeoObservableList);
        listView.setHeadersFunction(DatosSondeo::getFechaInicio);
        listView.setCellFactory(p -> new DatosSondeoCell());
        listView.setHeaderCellFactory(p -> new HeaderCellDatosSondeo());
        listView.setPlaceholder(new Label("No se han agregado sondeos"));
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        AppManager.getInstance().getDrawer().open()));
                appBar.setTitleText("Primary");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e ->
                        System.out.println("Search")));
            }
        });
        var fab = new FloatingActionButton(MaterialDesignIcon.ADD.text, e -> {
            datosSondeoPresenter.setData(null);
            AppViewManager.DATOS_SONDEO.switchView();
        });
        fab.showOn(primary);
    }

}
