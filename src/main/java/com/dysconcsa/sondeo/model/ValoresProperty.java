//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

import javafx.beans.property.*;

import java.util.Objects;

public class ValoresProperty {

    private IntegerProperty id;
    private DoubleProperty espesor;
    private StringProperty trepano;
    private IntegerProperty tipoSuelo;
    private StringProperty limiteLiquido;
    private StringProperty indicePlasticidad;
    private DoubleProperty indiceHumedad;
    private IntegerProperty recobro;
    private IntegerProperty golpes;
    private IntegerProperty idEmpresa;
    private DoubleProperty elevacion;

    public ValoresProperty() {
    }

    public ValoresProperty(double espesor, String trepano, int tipoSuelo, String limiteLiquido, String indicePlasticidad, double indiceHumedad, int recobro, int golpes, int empresa) {
        this.espesor = new SimpleDoubleProperty(espesor);
        this.trepano = new SimpleStringProperty(trepano);
        this.tipoSuelo = new SimpleIntegerProperty(tipoSuelo);
        this.limiteLiquido = new SimpleStringProperty(limiteLiquido);
        this.indicePlasticidad = new SimpleStringProperty(indicePlasticidad);
        this.indiceHumedad = new SimpleDoubleProperty(indiceHumedad);
        this.recobro = new SimpleIntegerProperty(recobro);
        this.golpes = new SimpleIntegerProperty(golpes);
        this.idEmpresa = new SimpleIntegerProperty(empresa);
        this.elevacion = new SimpleDoubleProperty(0.0D);
    }

    public ValoresProperty(double espesor, String trepano, int tipoSuelo, String limiteLiquido, String indicePlasticidad, double indiceHumedad, int recobro, int golpes, int empresa, double elevacion) {
        this.espesor = new SimpleDoubleProperty(espesor);
        this.trepano = new SimpleStringProperty(trepano);
        this.tipoSuelo = new SimpleIntegerProperty(tipoSuelo);
        this.limiteLiquido = new SimpleStringProperty(limiteLiquido);
        this.indicePlasticidad = new SimpleStringProperty(indicePlasticidad);
        this.indiceHumedad = new SimpleDoubleProperty(indiceHumedad);
        this.recobro = new SimpleIntegerProperty(recobro);
        this.golpes = new SimpleIntegerProperty(golpes);
        this.idEmpresa = new SimpleIntegerProperty(empresa);
        this.elevacion = new SimpleDoubleProperty(elevacion);
    }

    public int getId() {
        return this.id.get();
    }

    public IntegerProperty idProperty() {
        return this.id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public double getEspesor() {
        return this.espesor.get();
    }

    public DoubleProperty espesorProperty() {
        return this.espesor;
    }

    public void setEspesor(double espesor) {
        this.espesor.set(espesor);
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

    public int getTipoSuelo() {
        return this.tipoSuelo.get();
    }

    public IntegerProperty tipoSueloProperty() {
        return this.tipoSuelo;
    }

    public void setTipoSuelo(int tipoSuelo) {
        this.tipoSuelo.set(tipoSuelo);
    }

    public String getLimiteLiquido() {
        return (String)this.limiteLiquido.get();
    }

    public StringProperty limiteLiquidoProperty() {
        return this.limiteLiquido;
    }

    public void setLimiteLiquido(String limiteLiquido) {
        this.limiteLiquido.set(limiteLiquido);
    }

    public String getIndicePlasticidad() {
        return (String)this.indicePlasticidad.get();
    }

    public StringProperty indicePlasticidadProperty() {
        return this.indicePlasticidad;
    }

    public void setIndicePlasticidad(String indicePlasticidad) {
        this.indicePlasticidad.set(indicePlasticidad);
    }

    public double getIndiceHumedad() {
        return this.indiceHumedad.get();
    }

    public DoubleProperty indiceHumedadProperty() {
        return this.indiceHumedad;
    }

    public void setIndiceHumedad(double indiceHumedad) {
        this.indiceHumedad.set(indiceHumedad);
    }

    public int getRecobro() {
        return this.recobro.get();
    }

    public IntegerProperty recobroProperty() {
        return this.recobro;
    }

    public void setRecobro(int recobro) {
        this.recobro.set(recobro);
    }

    public int getGolpes() {
        return this.golpes.get();
    }

    public IntegerProperty golpesProperty() {
        return this.golpes;
    }

    public void setGolpes(int golpes) {
        this.golpes.set(golpes);
    }

    public int getIdEmpresa() {
        return this.idEmpresa.get();
    }

    public IntegerProperty idEmpresaProperty() {
        return this.idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa.set(idEmpresa);
    }

    public double getElevacion() {
        return this.elevacion.get();
    }

    public DoubleProperty elevacionProperty() {
        return this.elevacion;
    }

    public void setElevacion(double elevacion) {
        this.elevacion.set(elevacion);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ValoresProperty that = (ValoresProperty)o;
            return Objects.equals(this.recobro, that.recobro);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.recobro});
    }

    public String toString() {
        return "ValoresProperty{id=" + this.id + ", espesor=" + this.espesor + ", trepano=" + this.trepano + ", tipoSuelo=" + this.tipoSuelo + ", limiteLiquido=" + this.limiteLiquido + ", indicePlasticidad=" + this.indicePlasticidad + ", indiceHumedad=" + this.indiceHumedad + ", recobro=" + this.recobro + ", golpes=" + this.golpes + ", idEmpresa=" + this.idEmpresa + ", elevacion=" + this.elevacion + '}';
    }
}
