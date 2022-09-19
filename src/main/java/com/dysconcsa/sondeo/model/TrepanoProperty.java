//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TrepanoProperty {
    private final DoubleProperty profundidad;
    private final StringProperty trepano;

    public TrepanoProperty() {
        this.profundidad = new SimpleDoubleProperty(0.0D);
        this.trepano = new SimpleStringProperty("");
    }

    public TrepanoProperty(Double profundidad, String trepano) {
        this.profundidad = new SimpleDoubleProperty(profundidad);
        this.trepano = new SimpleStringProperty(trepano);
    }

    public double getProfundidad() {
        return this.profundidad.get();
    }

    public DoubleProperty profundidadProperty() {
        return this.profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad.set(profundidad);
    }

    public String getTrepano() {
        return (String)this.trepano.get();
    }

    public StringProperty trepanoProperty() {
        return this.trepano;
    }

    public void setTrepano(String trepano) {
        this.trepano.set(trepano);
    }
}
