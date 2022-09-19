//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdemeProperty {

    private DoubleProperty profundidad;
    private StringProperty descripcion;

    public AdemeProperty() {
        this.profundidad = new SimpleDoubleProperty(0.0D);
        this.descripcion = new SimpleStringProperty("Se ademo hasta 0.0");
    }

    public AdemeProperty(Double profundidad, String descripcion) {
        this.profundidad = new SimpleDoubleProperty(profundidad);
        this.descripcion = new SimpleStringProperty(descripcion);
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

    public String getDescripcion() {
        return (String)this.descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public String toString() {
        return "Se ademo hasta " + this.profundidad.get();
    }
}
