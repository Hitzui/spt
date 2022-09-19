package com.dysconcsa.sondeo.views;

import com.dysconcsa.sondeo.model.DatosSondeo;
import com.dysconcsa.sondeo.util.DateUtil;
import com.dysconcsa.sondeo.util.Variables;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.DatePicker;
import com.gluonhq.charm.glisten.control.Dialog;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DatosSondeoPresenter implements Initializable {
    private LocalDate fechaInicio = LocalDate.now();
    private LocalDate fechaFin = LocalDate.now();

    @FXML
    public TextField txtProyecto;
    @FXML
    public TextField txtUbicacion;
    @FXML
    public TextField txtCoordX;
    @FXML
    public TextField txtCoordY;
    @FXML
    public TextField txtSupervisor;
    @FXML
    public TextField txtSondeoNo;
    @FXML
    public Button btnFechaInicio;
    @FXML
    public Label lblFechaInicio;
    @FXML
    public Button btnFechaFinal;
    @FXML
    public Label lblFechaFinal;
    @FXML
    public TextField txtOperador;
    @FXML
    public TextField txtNivelFreatico;
    @FXML
    public TextField txtProfundidadMinima;
    @FXML
    public TextField txtProfundidadMaxima;
    @FXML
    public TextField txtElevacion;
    @FXML
    public TextField txtObservaciones;
    @FXML
    public View view;
    private DatosSondeo datos = null;
    private boolean isNew = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.view.setShowTransitionFactory(BounceInRightTransition::new);
        this.view.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                if (txtSondeoNo.getText().isBlank()) {
                    txtSondeoNo.setText(String.valueOf(Variables.getInstance().datosSondeoObservableList.size() + 1));
                }
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button((e) -> {
                    cancel();
                    AppViewManager.PRIMARY_VIEW.switchView();
                }));
                appBar.setTitleText("Datos Sondeo");
/*                appBar.getActionItems().add(MaterialDesignIcon.SAVE.button((e) -> {

                }));*/
            }

        });
        txtSondeoNo.getProperties().put("vkType", "numeric");
        btnFechaInicio.setOnAction(e -> {
            var datePicker = new DatePicker();
            datePicker.setDate(fechaInicio);
            datePicker.showAndWait().ifPresent(localDate -> fechaInicio = localDate);
            lblFechaInicio.setText(fechaInicio.toString());
        });
        btnFechaFinal.setOnAction(e -> {
            var datePicker = new DatePicker();
            datePicker.setDate(fechaFin);
            datePicker.showAndWait().ifPresent(localDate -> fechaFin = localDate);
            lblFechaFinal.setText(fechaFin.toString());
        });
    }

    public void setData(DatosSondeo datosSondeo) {
        if (datosSondeo != null) {
            isNew = false;
            this.datos = datosSondeo;
            txtSondeoNo.setText(datosSondeo.getSondeoNumero());
            txtCoordX.setText(String.valueOf(datosSondeo.getCoordenadaX()));
            txtCoordY.setText(String.valueOf(datosSondeo.getCoordenadaY()));
            txtElevacion.setText(String.valueOf(datosSondeo.getElevacion()));
            txtObservaciones.setText(datosSondeo.getObservaciones());
            txtNivelFreatico.setText(datosSondeo.getNivelFreatico());
            txtOperador.setText(datosSondeo.getOperador());
            txtProfundidadMaxima.setText(String.valueOf(datosSondeo.getProfundidadMaxima()));
            txtProfundidadMinima.setText(String.valueOf(datosSondeo.getProfundidadMinima()));
            txtProyecto.setText(datosSondeo.getProyecto());
            txtSupervisor.setText(datosSondeo.getSupervisor());
            txtUbicacion.setText(datosSondeo.getUbicacion());
            lblFechaInicio.setText(DateUtil.format(datosSondeo.getFechaInicio()));
            fechaInicio = datosSondeo.getFechaInicio();
            fechaFin = datosSondeo.getFechaFin();
            lblFechaFinal.setText(DateUtil.format(datosSondeo.getFechaFin()));
        }
    }

    private void cancel() {
        datos = null;
        isNew = true;
        txtSondeoNo.setText("");
        txtCoordX.setText("");
        txtCoordY.setText("");
        txtElevacion.setText("");
        txtObservaciones.setText("");
        txtNivelFreatico.setText("");
        txtOperador.setText("");
        txtProfundidadMaxima.setText("");
        txtProfundidadMinima.setText("");
        txtProyecto.setText("");
        txtSupervisor.setText("");
        txtUbicacion.setText("");
        lblFechaInicio.setText("");
        lblFechaFinal.setText("");
    }

    public void setDialog(Dialog<Object> dialog) {
    }

    public void action_Save() {
        if (datos == null) {
            datos = new DatosSondeo();
        }
        datos.setProyecto(txtProyecto.getText());
        datos.setSupervisor(txtSupervisor.getText());
        datos.setSondeoNumero(txtSondeoNo.getText());
        datos.setElevacion(Double.parseDouble(txtElevacion.getText()));
        datos.setProfundidadMinima(Double.parseDouble(txtProfundidadMinima.getText()));
        datos.setProfundidadMaxima(Double.parseDouble(txtProfundidadMaxima.getText()));
        datos.setFechaInicio(fechaInicio);
        datos.setFechaFin(fechaFin);
        datos.setUbicacion(txtUbicacion.getText());
        datos.setOperador(txtOperador.getText());
        datos.setObservaciones(txtObservaciones.getText());
        datos.setNivelFreatico(txtNivelFreatico.getText());
        datos.setCoordenadaX(Double.parseDouble(txtCoordX.getText()));
        datos.setCoordenadaY(Double.parseDouble(txtCoordY.getText()));
        if (!isNew) {
            Variables.getInstance().datosSondeoObservableList.remove(datos);
        }
        Variables.getInstance().datosSondeoObservableList.add(datos);
        cancel();
        AppViewManager.PRIMARY_VIEW.switchView();
    }

}
