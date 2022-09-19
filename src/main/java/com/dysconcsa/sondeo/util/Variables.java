package com.dysconcsa.sondeo.util;

import com.dysconcsa.sondeo.dao.DaoSuelos;
import com.dysconcsa.sondeo.model.ClasificacionSucsProperty;
import com.dysconcsa.sondeo.model.DatosCampoProperty;
import com.dysconcsa.sondeo.model.DatosSondeo;
import com.dysconcsa.sondeo.model.SuelosProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Variables {
    private static Variables instance;
    private Variables() {
    }
    public static Variables getInstance() {
        if (instance == null) {
            instance = new Variables();
        }
        return instance;
    }

    /*
     * Variables de lista usados en la aplicacion
     */

    public ObservableList<ClasificacionSucsProperty> clasificacionSucsObservableList = FXCollections.observableArrayList();
    public ObservableList<DatosSondeo> datosSondeoObservableList = FXCollections.observableArrayList();
    public ObservableList<DatosCampoProperty> datosCampoProperties = FXCollections.observableArrayList();
    public ObservableList<SuelosProperty> suelosPropertyObservableList=FXCollections.observableArrayList();
}
