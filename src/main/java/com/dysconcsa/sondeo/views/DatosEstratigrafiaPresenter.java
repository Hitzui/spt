package com.dysconcsa.sondeo.views;

import com.dysconcsa.sondeo.dao.DaoSuelos;
import com.dysconcsa.sondeo.model.ClasificacionSucsProperty;
import com.dysconcsa.sondeo.model.Model;
import com.dysconcsa.sondeo.model.SuelosProperty;
import com.dysconcsa.sondeo.util.Util;
import com.dysconcsa.sondeo.util.Variables;
import com.gluonhq.charm.glisten.animation.FadeInLeftBigTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.apache.poi.ss.usermodel.FillPatternType;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class DatosEstratigrafiaPresenter implements Initializable {

    @Inject
    private Model model;

    private boolean editMode;

    @FXML
    public View view;
    @FXML
    private Button btnGuardar;
    @FXML
    private ComboBox<FillPatternType> cmbPattern;
    @FXML
    private ComboBox<SuelosProperty> cmbTipoSuelo;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtIndicePlasticidad;
    @FXML
    private TextField txtLimiteLiquido;
    @FXML
    private TextField txtProfundidad;
    private final ObservableList<FillPatternType> patternTypesProperties = FXCollections.observableArrayList();
    DaoSuelos daoSuelos = new DaoSuelos();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Variables.getInstance().suelosPropertyObservableList.clear();
        colorPicker.setOnAction(e -> {
            var value = colorPicker.getValue();
            System.out.println(Util.getHexColor(value));
        });
        cmbTipoSuelo.setItems(Variables.getInstance().suelosPropertyObservableList);
        cmbPattern.setItems(patternTypesProperties);
        this.view.setShowTransitionFactory(FadeInLeftBigTransition::new);
        this.view.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                Variables.getInstance().suelosPropertyObservableList.addAll(daoSuelos.findAll());
                loadPattern();
                btnGuardar.disableProperty().unbind();
                ClasificacionSucsProperty clasificacionSucsProperty = model.getActiveClasificacionSucs();
                if (clasificacionSucsProperty != null) {
                    btnGuardar.setText("Aplicar Cambios");
                    txtDescripcion.setText(clasificacionSucsProperty.getDescripcion());
                    txtProfundidad.setText(String.valueOf(clasificacionSucsProperty.getProfundidad()));
                    txtLimiteLiquido.setText(String.valueOf(clasificacionSucsProperty.getLimiteLiquido()));
                    txtIndicePlasticidad.setText(String.valueOf(clasificacionSucsProperty.getIndicePlasticidad()));
                    cmbPattern.setValue(clasificacionSucsProperty.getPattern());
                    cmbTipoSuelo.setValue(clasificacionSucsProperty.getTipoSuelo());
                    btnGuardar.disableProperty().bind(Bindings.createBooleanBinding(() -> {
                        if (txtDescripcion == null || txtProfundidad == null) {
                            return true;
                        }
                        return txtDescripcion.textProperty()
                                .isEqualTo(clasificacionSucsProperty.getDescripcion())
                                .and(txtProfundidad.textProperty()
                                        .isEqualTo(String.valueOf(clasificacionSucsProperty.profundidadProperty()))).get();
                    }, txtDescripcion.textProperty(), txtProfundidad.textProperty()));
                    editMode = true;
                } else {
                    btnGuardar.setText("Guardar");
                    btnGuardar.disableProperty().bind(Bindings.createBooleanBinding(() -> {
                        return txtDescripcion.textProperty()
                                .isEmpty()
                                .or(txtProfundidad.textProperty()
                                        .isEmpty()).get();
                    }, txtDescripcion.textProperty(), txtProfundidad.textProperty()));
                    editMode = false;
                }
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(this::close));
                appBar.setTitleText("Estratigrafia del Sondeo");
            } else {
                txtDescripcion.clear();
                txtProfundidad.clear();
                txtIndicePlasticidad.clear();
                txtLimiteLiquido.clear();
                cmbTipoSuelo.setValue(null);
                cmbPattern.setValue(null);
            }
        });
        btnGuardar.setOnAction(event -> {
            var clasificacion = editMode ? model.activeClasificacionSucsProperty().get() : new ClasificacionSucsProperty();
            if (editMode) {
                Variables.getInstance().clasificacionSucsObservableList.remove(clasificacion);
            }
            clasificacion.setDescripcion(txtDescripcion.getText());
            clasificacion.setProfundidad(Double.parseDouble(txtProfundidad.getText()));
            clasificacion.setPattern(cmbPattern.getValue());
            clasificacion.setLimiteLiquido(Integer.parseInt(txtLimiteLiquido.getText()));
            clasificacion.setIndicePlasticidad(Integer.parseInt(txtIndicePlasticidad.getText()));
            clasificacion.setTipoSuelo(cmbTipoSuelo.getValue());
            Variables.getInstance().clasificacionSucsObservableList.add(clasificacion);
            AppViewManager.ESTRATIGRAFIA.switchView();
        });
    }

    private void loadPattern() {
        patternTypesProperties.clear();
        patternTypesProperties.addAll(FillPatternType.values());
    }

    private void close(ActionEvent event) {
        txtDescripcion.clear();
        txtProfundidad.clear();
        txtIndicePlasticidad.clear();
        txtLimiteLiquido.clear();
        cmbTipoSuelo.setValue(null);
        cmbPattern.setValue(null);
        model.activeClasificacionSucsProperty().set(null);
        AppViewManager.ESTRATIGRAFIA.switchView();
    }
}
