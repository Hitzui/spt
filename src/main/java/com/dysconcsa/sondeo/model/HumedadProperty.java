//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class HumedadProperty {
    private final DoubleProperty profundidadInicial;
    private final DoubleProperty profundidadFinal;
    private final DoubleProperty humedad;

    public HumedadProperty() {
        this.profundidadInicial = new SimpleDoubleProperty(0.0D);
        this.profundidadFinal = new SimpleDoubleProperty(1.5D);
        this.humedad = new SimpleDoubleProperty(0.0D);
    }

    public HumedadProperty(Double profundidadInicial, Double profundidadFinal, Double humedad) {
        this.profundidadInicial = new SimpleDoubleProperty(profundidadInicial);
        this.profundidadFinal = new SimpleDoubleProperty(profundidadFinal);
        this.humedad = new SimpleDoubleProperty(humedad);
    }

    public double getProfundidadInicial() {
        return this.profundidadInicial.get();
    }

    public DoubleProperty profundidadInicialProperty() {
        return this.profundidadInicial;
    }

    public void setProfundidadInicial(double profundidadInicial) {
        this.profundidadInicial.set(profundidadInicial);
    }

    public double getProfundidadFinal() {
        return this.profundidadFinal.get();
    }

    public DoubleProperty profundidadFinalProperty() {
        return this.profundidadFinal;
    }

    public void setProfundidadFinal(double profundidadFinal) {
        this.profundidadFinal.set(profundidadFinal);
    }

    public double getHumedad() {
        return this.humedad.get();
    }

    public DoubleProperty humedadProperty() {
        return this.humedad;
    }

    public void setHumedad(double humedad) {
        this.humedad.set(humedad);
    }
}
