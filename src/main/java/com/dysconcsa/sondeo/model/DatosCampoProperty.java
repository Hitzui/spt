//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

import javafx.beans.property.*;

public class DatosCampoProperty {

    private final StringProperty noMuestra;
    private DoubleProperty profundidadInicial;
    private final DoubleProperty profundidadFinal;
    private final IntegerProperty recobro;
    private final IntegerProperty golpe1;
    private final IntegerProperty golpe2;
    private final IntegerProperty golpe3;
    private StringProperty observacion;
    private DoubleProperty rotado;

    public DatosCampoProperty() {
        this.profundidadInicial = new SimpleDoubleProperty(0.0D);
        this.profundidadFinal = new SimpleDoubleProperty(1.5D);
        this.recobro = new SimpleIntegerProperty(0);
        this.golpe1 = new SimpleIntegerProperty(0);
        this.golpe2 = new SimpleIntegerProperty(0);
        this.golpe3 = new SimpleIntegerProperty(0);
        this.noMuestra = new SimpleStringProperty("");
        this.observacion = new SimpleStringProperty("");
        this.rotado = new SimpleDoubleProperty(0.0D);
    }

    public DatosCampoProperty(Double profundidadInicial, Double profundidadFinal, Integer recobro, Integer golpe1, Integer golpe2, Integer golpe3) {
        this.profundidadInicial = new SimpleDoubleProperty(profundidadInicial);
        this.profundidadFinal = new SimpleDoubleProperty(profundidadFinal);
        this.recobro = new SimpleIntegerProperty(recobro);
        this.golpe1 = new SimpleIntegerProperty(golpe1);
        this.golpe2 = new SimpleIntegerProperty(golpe2);
        this.golpe3 = new SimpleIntegerProperty(golpe3);
        this.observacion = new SimpleStringProperty("");
        this.noMuestra = new SimpleStringProperty("");
        this.rotado = new SimpleDoubleProperty(0.0D);
    }

    public DatosCampoProperty(StringProperty noMuestra, DoubleProperty profundidadInicial, DoubleProperty profundidadFinal, IntegerProperty recobro, IntegerProperty golpe1, IntegerProperty golpe2, IntegerProperty golpe3, StringProperty observacion) {
        this.noMuestra = noMuestra;
        this.profundidadInicial = profundidadInicial;
        this.profundidadFinal = profundidadFinal;
        this.recobro = recobro;
        this.golpe1 = golpe1;
        this.golpe2 = golpe2;
        this.golpe3 = golpe3;
        this.observacion = observacion;
    }

    public double getRotado() {
        return this.rotado.get();
    }

    public DoubleProperty rotadoProperty() {
        return this.rotado;
    }

    public void setRotado(double rotado) {
        this.rotado.set(rotado);
    }

    public String getNoMuestra() {
        return (String) this.noMuestra.get();
    }

    public StringProperty noMuestraProperty() {
        return this.noMuestra;
    }

    public void setNoMuestra(String noMuestra) {
        this.noMuestra.set(noMuestra);
    }

    public void setProfundidadInicial(double profundidadInicial) {
        this.profundidadInicial.set(profundidadInicial);
    }

    public void setProfundidadFinal(double profundidadFinal) {
        this.profundidadFinal.set(profundidadFinal);
    }

    public void setRecobro(int recobro) {
        this.recobro.set(recobro);
    }

    public void setGolpe1(int golpe1) {
        this.golpe1.set(golpe1);
    }

    public void setGolpe2(int golpe2) {
        this.golpe2.set(golpe2);
    }

    public void setGolpe3(int golpe3) {
        this.golpe3.set(golpe3);
    }

    public String getObservacion() {
        if (this.observacion == null) {
            this.observacion=new SimpleStringProperty("");
        }

        return this.observacion.get();
    }

    public StringProperty observacionProperty() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion.set(observacion);
    }

    public double getProfundidadInicial() {
        if (this.profundidadInicial == null) {
            this.profundidadInicial = new SimpleDoubleProperty(0d);
        }
        return this.profundidadInicial.get();
    }

    public DoubleProperty profundidadInicialProperty() {
        return this.profundidadInicial;
    }

    public void setProfundidadInicial(Number profundidadInicial) {
        this.profundidadInicial.set((Double) profundidadInicial);
    }

    public double getProfundidadFinal() {
        return this.profundidadFinal.get();
    }

    public DoubleProperty profundidadFinalProperty() {
        return this.profundidadFinal;
    }

    public void setProfundidadFinal(Number profundidadFinal) {
        this.profundidadFinal.set((Double) profundidadFinal);
    }

    public int getRecobro() {
        return this.recobro.get();
    }

    public IntegerProperty recobroProperty() {
        return this.recobro;
    }

    public void setRecobro(Number recobro) {
        this.recobro.set((Integer) recobro);
    }

    public int getGolpe1() {
        return this.golpe1.get();
    }

    public IntegerProperty golpe1Property() {
        return this.golpe1;
    }

    public void setGolpe1(Number golpe1) {
        this.golpe1.set((Integer) golpe1);
    }

    public int getGolpe2() {
        return this.golpe2.get();
    }

    public IntegerProperty golpe2Property() {
        return this.golpe2;
    }

    public void setGolpe2(Number golpe2) {
        this.golpe2.set((Integer) golpe2);
    }

    public int getGolpe3() {
        return this.golpe3.get();
    }

    public IntegerProperty golpe3Property() {
        return this.golpe3;
    }

    public void setGolpe3(Number golpe3) {
        this.golpe3.set((Integer) golpe3);
    }

    public String toString() {
        return "DatosCampoProperty{profundidadInicial=" + this.profundidadInicial + ", profundidadFinal=" + this.profundidadFinal + ", recobro=" + this.recobro + '}';
    }
}
