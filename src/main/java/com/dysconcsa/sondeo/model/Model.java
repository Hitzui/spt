package com.dysconcsa.sondeo.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Model {
    private final ObjectProperty<ClasificacionSucsProperty> activeClasificacionSucs = new SimpleObjectProperty<>();

    public ClasificacionSucsProperty getActiveClasificacionSucs() {
        return activeClasificacionSucs.get();
    }

    public ObjectProperty<ClasificacionSucsProperty> activeClasificacionSucsProperty() {
        return activeClasificacionSucs;
    }
}
