//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

import com.dysconcsa.sondeo.util.DateUtil;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class DatosSondeo {

    private StringProperty proyecto;
    private StringProperty supervisor;
    private StringProperty ubicacion;
    private final StringProperty sondeoNumero;
    private final ObjectProperty<Double> profundidadMinima;
    private final ObjectProperty<Double> profundidadMaxima;
    private final StringProperty observaciones;
    private final StringProperty operador;
    private final StringProperty archivo;
    private final StringProperty nivelFreatico;
    private final ObjectProperty<Double> elevacion;
    private final ObjectProperty<LocalDate> fechaInicio;
    private ObjectProperty<LocalDate> fechaFin;
    private ObjectProperty<Double> coordenadaX;
    private ObjectProperty<Double> coordenadaY;

    public DatosSondeo() {
        this.fechaFin = new SimpleObjectProperty<>(LocalDate.now());
        this.profundidadMaxima = new SimpleObjectProperty<>(0.0d);
        this.profundidadMinima = new SimpleObjectProperty<>(0.0d);
        this.elevacion = new SimpleObjectProperty<>(0.0d);
        this.fechaInicio = new SimpleObjectProperty<>(LocalDate.now());
        this.coordenadaX = new SimpleObjectProperty<>(0d);
        this.coordenadaY = new SimpleObjectProperty<>(0d);
        this.sondeoNumero = new SimpleStringProperty();
        this.observaciones = new SimpleStringProperty();
        this.operador = new SimpleStringProperty();
        this.archivo = new SimpleStringProperty();
        this.nivelFreatico = new SimpleStringProperty();
        this.proyecto = new SimpleStringProperty("");
        this.supervisor = new SimpleStringProperty("");
        this.ubicacion = new SimpleStringProperty("");
    }

    public DatosSondeo(String sondeoNumero,
                       Double profundidadMinima, Double profundidadMaxima,
                       String lugar, String observaciones, String operador,
                       String archivo, String nivelFreatico, Double elevacion, String fechaInicio) {
        this.sondeoNumero = new SimpleStringProperty(sondeoNumero);
        this.profundidadMinima = new SimpleObjectProperty<>(profundidadMinima);
        this.profundidadMaxima = new SimpleObjectProperty<>(profundidadMaxima);
        this.ubicacion = new SimpleStringProperty(lugar);
        this.observaciones = new SimpleStringProperty(observaciones);
        this.operador = new SimpleStringProperty(operador);
        this.archivo = new SimpleStringProperty(archivo);
        this.nivelFreatico = new SimpleStringProperty(nivelFreatico);
        this.elevacion = new SimpleObjectProperty<>(elevacion);
        this.fechaInicio = new SimpleObjectProperty<>(DateUtil.parse(fechaInicio));
    }

    public LocalDate getFechaFin() {
        return fechaFin.get();
    }

    public ObjectProperty<LocalDate> fechaFinProperty() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin.set(fechaFin);
    }

    public String getUbicacion() {
        return ubicacion.get();
    }

    public StringProperty ubicacionProperty() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion.set(ubicacion);
    }

    public String getProyecto() {
        return proyecto.get();
    }

    public StringProperty proyectoProperty() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto.set(proyecto);
    }

    public String getSupervisor() {
        return supervisor.get();
    }

    public StringProperty supervisorProperty() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor.set(supervisor);
    }

    public String getSondeoNumero() {
        return sondeoNumero.get();
    }

    public StringProperty sondeoNumeroProperty() {
        return sondeoNumero;
    }

    public void setSondeoNumero(String sondeoNumero) {
        this.sondeoNumero.set(sondeoNumero);
    }

    public Double getProfundidadMinima() {
        return profundidadMinima.get();
    }

    public ObjectProperty<Double> profundidadMinimaProperty() {
        return profundidadMinima;
    }

    public void setProfundidadMinima(Double profundidadMinima) {
        this.profundidadMinima.set(profundidadMinima);
    }

    public Double getProfundidadMaxima() {
        return profundidadMaxima.get();
    }

    public ObjectProperty<Double> profundidadMaximaProperty() {
        return profundidadMaxima;
    }

    public void setProfundidadMaxima(Double profundidadMaxima) {
        this.profundidadMaxima.set(profundidadMaxima);
    }


    public String getObservaciones() {
        return observaciones.get();
    }

    public StringProperty observacionesProperty() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones.set(observaciones);
    }

    public String getOperador() {
        return operador.get();
    }

    public StringProperty operadorProperty() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador.set(operador);
    }

    public String getArchivo() {
        return archivo.get();
    }

    public StringProperty archivoProperty() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo.set(archivo);
    }

    public String getNivelFreatico() {
        return nivelFreatico.get();
    }

    public StringProperty nivelFreaticoProperty() {
        return nivelFreatico;
    }

    public void setNivelFreatico(String nivelFreatico) {
        this.nivelFreatico.set(nivelFreatico);
    }

    public Double getElevacion() {
        return elevacion.get();
    }

    public ObjectProperty<Double> elevacionProperty() {
        return elevacion;
    }

    public void setElevacion(Double elevacion) {
        this.elevacion.set(elevacion);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio.get();
    }

    public ObjectProperty<LocalDate> fechaInicioProperty() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio.set(fechaInicio);
    }

    public Double getCoordenadaX() {
        return coordenadaX.get();
    }

    public ObjectProperty<Double> coordenadaXProperty() {
        return coordenadaX;
    }

    public void setCoordenadaX(Double coordenadaX) {
        this.coordenadaX.set(coordenadaX);
    }

    public Double getCoordenadaY() {
        return coordenadaY.get();
    }

    public ObjectProperty<Double> coordenadaYProperty() {
        return coordenadaY;
    }

    public void setCoordenadaY(Double coordenadaY) {
        this.coordenadaY.set(coordenadaY);
    }

    public String toString() {
        return "ProfundidadSondeo{sondeoNumero='" + this.sondeoNumero + '\'' + ", profundidadMinima=" + this.profundidadMinima + ", profundidadMaxima=" + this.profundidadMaxima + ", lugar='" + this.ubicacion + '\'' + ", observaciones='" + this.observaciones + '\'' + ", operador='" + this.operador + '\'' + ", archivo='" + this.archivo + '\'' + ", nivelFreatico='" + this.nivelFreatico + '\'' + ", elevacion=" + this.elevacion + '}';
    }
}
