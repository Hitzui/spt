package com.dysconcsa.sondeo.views;

import com.dysconcsa.sondeo.model.DatosCampoProperty;
import com.dysconcsa.sondeo.util.Variables;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.logging.Logger;

public class EditarvaloresPresenter {
    Logger logger = Logger.getLogger(getClass().getName());
    @FXML
    public View view;
    @FXML
    public TextField txtGolpe1;
    @FXML
    public TextField txtGolpe2;
    @FXML
    public TextField txtGolpe3;
    @FXML
    public TextField txtObservaciones;
    @FXML
    public TextField txtProfundidadInicial;
    @FXML
    public TextField txtProfunidadFinal;
    @FXML
    public TextField txtRecobro;

    private boolean isNew = true;
    private DatosCampoProperty datos = null;

    @FXML
    public void initialize() {
        this.view.setShowTransitionFactory(BounceInRightTransition::new);
        this.view.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                if (isNew) {
                    var ultimoDatoCampo = Variables.getInstance().datosCampoProperties.get(Variables.getInstance().datosCampoProperties.size() - 1);
                    txtProfundidadInicial.setText(String.valueOf(ultimoDatoCampo.getProfundidadFinal()));
                    txtProfunidadFinal.setText(String.valueOf(ultimoDatoCampo.getProfundidadFinal() + 1.5));
                }
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button((e) -> {
                    cancel();
                    AppViewManager.VALORES_SPT.switchView();
                }));
                appBar.setTitleText("Valores de Campo");
                appBar.getActionItems().add(MaterialDesignIcon.SAVE.button((e) -> {
                    if (datos == null) {
                        datos = new DatosCampoProperty();
                    }
                    if (!isNew) {
                        Variables.getInstance().datosCampoProperties.remove(datos);
                    }
                    if (txtProfundidadInicial.getText().isBlank() ||
                            txtProfunidadFinal.getText().isBlank() ||
                            txtRecobro.getText().isBlank() ||
                            txtGolpe1.isCache() || txtGolpe2.getText().isBlank() ||
                            txtGolpe3.getText().isBlank()) {
                        return;
                    }
                    datos.setGolpe1(Integer.parseInt(txtGolpe1.getText()));
                    datos.setGolpe2(Integer.parseInt(txtGolpe2.getText()));
                    datos.setGolpe3(Integer.parseInt(txtGolpe3.getText()));
                    datos.setRecobro(Integer.parseInt(txtRecobro.getText()));
                    datos.setProfundidadInicial(Double.parseDouble(txtProfundidadInicial.getText()));
                    datos.setProfundidadFinal(Double.parseDouble(txtProfunidadFinal.getText()));
                    datos.setObservacion(txtObservaciones.getText());
                    Variables.getInstance().datosCampoProperties.add(datos);
                    cancel();
                    AppViewManager.VALORES_SPT.switchView();
                }));
            }

        });
    }

    public void setData(DatosCampoProperty datosCampoProperty) {
        if (datosCampoProperty != null) {
            isNew = false;
            this.datos = datosCampoProperty;
            logger.info(datos.toString());
            txtProfunidadFinal.setText(String.valueOf(datosCampoProperty.getProfundidadFinal()));
            txtProfundidadInicial.setText(String.valueOf(datosCampoProperty.getProfundidadInicial()));
            txtRecobro.setText(String.valueOf(datosCampoProperty.getRecobro()));
            txtGolpe1.setText(String.valueOf(datosCampoProperty.getGolpe1()));
            txtGolpe2.setText(String.valueOf(datosCampoProperty.getGolpe2()));
            txtGolpe3.setText(String.valueOf(datosCampoProperty.getGolpe3()));
            txtObservaciones.setText(datosCampoProperty.getObservacion());
        }
    }

    private void cancel() {
        isNew = true;
        datos = null;
        txtGolpe1.clear();
        txtGolpe2.clear();
        txtGolpe3.clear();
        txtProfundidadInicial.clear();
        txtProfunidadFinal.clear();
        txtRecobro.clear();
        txtObservaciones.clear();
    }
}
