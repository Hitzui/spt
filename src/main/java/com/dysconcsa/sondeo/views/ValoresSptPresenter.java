package com.dysconcsa.sondeo.views;

import com.dysconcsa.sondeo.model.DatosCampoProperty;
import com.dysconcsa.sondeo.model.SuelosProperty;
import com.dysconcsa.sondeo.util.EditCell;
import com.dysconcsa.sondeo.util.Variables;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.Alert;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ValoresSptPresenter implements Initializable {

    Logger logger = Logger.getLogger(getClass().getName());
    @Inject
    private EditarvaloresPresenter editarvaloresPresenter;

    @FXML
    public View view;
    @FXML
    public TableView<DatosCampoProperty> tableDatos;
    @FXML
    public TableColumn<DatosCampoProperty, Double> colProfundidadInicial;
    @FXML
    public TableColumn<DatosCampoProperty, Double> colProfundidadFinal;
    @FXML
    public TableColumn<DatosCampoProperty, Integer> colGolpe1;
    @FXML
    public TableColumn<DatosCampoProperty, Integer> colGolpe2;
    @FXML
    public TableColumn<DatosCampoProperty, Integer> colGolpe3;
    @FXML
    public TableColumn<DatosCampoProperty, Integer> colRecobro;

    private final ObservableList<IndexedColors> itemsColorPoperties = FXCollections.observableArrayList();
    private final ObservableList<FillPatternType> patternTypesProperties = FXCollections.observableArrayList();
    private final ObservableList<SuelosProperty> suelosProperties = FXCollections.observableArrayList();
    private DatosCampoProperty selected;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableDatos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selected = newValue;
            }
        });
        if (Variables.getInstance().datosCampoProperties.size() <= 0) {
            Variables.getInstance().datosCampoProperties.add(new DatosCampoProperty(0d, 1.5, 0, 0, 0, 0));
        }
        //Si es Mobil usar la siguiente instruccion para agregar un valor de campo
        if (Platform.isAndroid()) {
            var fab = new FloatingActionButton(MaterialDesignIcon.ADD.text, e -> {
                editarvaloresPresenter.setData(null);
                AppViewManager.EDIT_VALORES_SPT.switchView();
            });
            fab.showOn(view);
        }
        this.view.setShowTransitionFactory(BounceInRightTransition::new);
        this.view.showingProperty().addListener((obs, oldValue, newValue) -> {
            AppBar appBar = AppManager.getInstance().getAppBar();
            appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                    AppManager.getInstance().getDrawer().open()));
            appBar.setTitleText("Valores de Campo del Sondeo");
            //Si es Mobil usar la siguiente instruccion para editar un valor de campo
            if (Platform.isAndroid()) {
                appBar.getActionItems().add(MaterialDesignIcon.EDIT.button(e -> {
                    selected = tableDatos.getSelectionModel().getSelectedItem();
                    var appView = AppViewManager.EDIT_VALORES_SPT;
                    if (appView.getPresenter().isPresent()) {
                        var presenter = (EditarvaloresPresenter) appView.getPresenter().get();
                        presenter.setData(selected);
                    }
                    appView.switchView();
                }));
            }
            appBar.getActionItems().add(MaterialDesignIcon.DELETE_FOREVER.button((e) -> {
                var alert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
                alert.setTitleText("Eliminar");
                alert.setContentText("Seguro desea eliminar el valor seleccionado? Esta accion no se puede revertir");
                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType == ButtonType.OK) {
                        Variables.getInstance().datosCampoProperties.remove(selected);
                    }
                });
            }));
        });
        tableDatos.setItems(Variables.getInstance().datosCampoProperties);
        setTableEditableDatos();
        setupGolpesColumn();
    }


    @SuppressWarnings("unchecked")
    private void editFocusedCellDatos() {
        final TablePosition<DatosCampoProperty, ?> focusedCell = tableDatos.focusModelProperty().get()
                .focusedCellProperty().get();
        tableDatos.edit(focusedCell.getRow(), focusedCell.getTableColumn());
    }

    private void setupGolpesColumn() {
        colProfundidadInicial.setCellFactory(EditCell.forTableColumn(new DoubleStringConverter()));
        colProfundidadInicial.setCellValueFactory(value -> value.getValue().profundidadInicialProperty().asObject());
        colProfundidadInicial.setOnEditCommit(event -> {
            final Double value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setProfundidadInicial(value);
            tableDatos.getSelectionModel().select(event.getTablePosition().getRow(), colProfundidadFinal);
            event.consume();
        });
        colProfundidadFinal.setCellFactory(EditCell.forTableColumn(new DoubleStringConverter()));
        colProfundidadFinal.setCellValueFactory(value -> value.getValue().profundidadFinalProperty().asObject());
        colProfundidadFinal.setOnEditCommit(event -> {
            final Double value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setProfundidadFinal(value);
            event.consume();
        });
        colRecobro.setCellFactory(EditCell.forTableColumn(new IntegerStringConverter()));
        colRecobro.setCellValueFactory(value -> value.getValue().recobroProperty().asObject());
        colRecobro.setOnEditCommit(event -> {
            final Integer value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setRecobro(value);
            tableDatos.getSelectionModel().select(event.getTablePosition().getRow(), colGolpe1);
            event.consume();
        });
        colGolpe1.setCellFactory(EditCell.forTableColumn(new IntegerStringConverter()));
        colGolpe1.setCellValueFactory(value -> value.getValue().golpe1Property().asObject());
        colGolpe1.setOnEditCommit(event -> {
            final Integer value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setGolpe1(value);
            tableDatos.getSelectionModel().select(event.getTablePosition().getRow(), colGolpe2);
            event.consume();
        });
        colGolpe2.setCellFactory(EditCell.forTableColumn(new IntegerStringConverter()));
        colGolpe2.setCellValueFactory(value -> value.getValue().golpe2Property().asObject());
        colGolpe2.setOnEditCommit(event -> {
            final Integer value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setGolpe2(value);
            tableDatos.getSelectionModel().select(event.getTablePosition().getRow(), colGolpe3);
            event.consume();
        });
        colGolpe3.setCellFactory(EditCell.forTableColumn(new IntegerStringConverter()));
        colGolpe3.setCellValueFactory(value -> value.getValue().golpe3Property().asObject());
        colGolpe3.setOnEditCommit(event -> {
            final Integer value = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setGolpe3(value);
            event.consume();
        });
    }

    public void action_btnEliminar() {
        if (Variables.getInstance().datosCampoProperties.size() <= 1) {
            return;
        }
        int index = tableDatos.getSelectionModel().getSelectedIndex();
        DatosCampoProperty datosCampoProperty = tableDatos.getSelectionModel().getSelectedItem();
        Variables.getInstance().datosCampoProperties.remove(datosCampoProperty);
    }


    @SuppressWarnings("unchecked")
    private void setTableEditableDatos() {
        tableDatos.setEditable(true);
        //tableDatos.getSelectionModel().cellSelectionEnabledProperty().set(true);
        tableDatos.setOnKeyPressed(event -> {
            TablePosition<DatosCampoProperty, ?> pos = tableDatos.getFocusModel().getFocusedCell();
            if (event.getCode().isDigitKey()) {
                editFocusedCellDatos();
            } else if (event.getCode() == KeyCode.DELETE) {
                action_btnEliminar();
            } else if (event.getCode() == KeyCode.TAB || event.getCode() == KeyCode.ENTER) {
                if (pos.getColumn() == 5) {
                    if (pos.getRow() == (tableDatos.getItems().size() - 1)) {
                        DatosCampoProperty datosCampoProperty = tableDatos.getItems().get(pos.getRow());
                        Double profIni = datosCampoProperty.getProfundidadFinal();
                        Double profFinal = datosCampoProperty.getProfundidadFinal() + 1.5;
                        Variables.getInstance().datosCampoProperties.add(new DatosCampoProperty(profIni, profFinal, 0, 0, 0, 0));
                        tableDatos.getSelectionModel().select(pos.getRow() + 1, colRecobro);
                        event.consume();
                    } else {
                        tableDatos.getSelectionModel().selectNext();
                    }
                } else {
                    tableDatos.getSelectionModel().selectNext();
                }
            }
        });
    }
}
