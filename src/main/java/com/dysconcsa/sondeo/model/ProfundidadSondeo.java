//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

public class ProfundidadSondeo {

    private String sondeoNumero;
    private Double profundidadMinima;
    private Double profundidadMaxima;
    private String lugar;
    private String observaciones;
    private String operador;
    private String archivo;
    private String nivelFreatico;
    private Double elevacion;
    private String fecha;

    public ProfundidadSondeo() {
    }

    public ProfundidadSondeo(String sondeoNumero, Double profundidadMinima, Double profundidadMaxima, String lugar, String observaciones, String operador, String archivo, String nivelFreatico, Double elevacion, String fecha) {
        this.sondeoNumero = sondeoNumero;
        this.profundidadMinima = profundidadMinima;
        this.profundidadMaxima = profundidadMaxima;
        this.lugar = lugar;
        this.observaciones = observaciones;
        this.operador = operador;
        this.archivo = archivo;
        this.nivelFreatico = nivelFreatico;
        this.elevacion = elevacion;
        this.fecha = fecha;
    }

    public String getSondeoNumero() {
        return this.sondeoNumero;
    }

    public void setSondeoNumero(String sondeoNumero) {
        this.sondeoNumero = sondeoNumero;
    }

    public Double getProfundidadMinima() {
        return this.profundidadMinima;
    }

    public void setProfundidadMinima(Double profundidadMinima) {
        this.profundidadMinima = profundidadMinima;
    }

    public Double getProfundidadMaxima() {
        return this.profundidadMaxima;
    }

    public void setProfundidadMaxima(Double profundidadMaxima) {
        this.profundidadMaxima = profundidadMaxima;
    }

    public Double getElevacion() {
        return this.elevacion;
    }

    public void setElevacion(Double elevacion) {
        this.elevacion = elevacion;
    }

    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOperador() {
        return this.operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getArchivo() {
        return this.archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getNivelFreatico() {
        return this.nivelFreatico;
    }

    public void setNivelFreatico(String nivelFreatico) {
        this.nivelFreatico = nivelFreatico;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return "ProfundidadSondeo{sondeoNumero='" + this.sondeoNumero + '\'' + ", profundidadMinima=" + this.profundidadMinima + ", profundidadMaxima=" + this.profundidadMaxima + ", lugar='" + this.lugar + '\'' + ", observaciones='" + this.observaciones + '\'' + ", operador='" + this.operador + '\'' + ", archivo='" + this.archivo + '\'' + ", nivelFreatico='" + this.nivelFreatico + '\'' + ", elevacion=" + this.elevacion + '}';
    }
}
