
package com.dysconcsa.sondeo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmpresaProperty  {

    private IntegerProperty id = new SimpleIntegerProperty(0);
    StringProperty cliente;
    StringProperty proyecto;
    StringProperty fecha;

    public EmpresaProperty(String cliente, String proyecto, String fecha) {
        this.cliente = new SimpleStringProperty(cliente);
        this.proyecto = new SimpleStringProperty(proyecto);
        this.fecha = new SimpleStringProperty(fecha);
    }

    public EmpresaProperty() {
        this.cliente = new SimpleStringProperty("");
        this.proyecto = new SimpleStringProperty("");
        this.fecha = new SimpleStringProperty("");
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

    public String getCliente() {
        return (String)this.cliente.get();
    }

    public StringProperty clienteProperty() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente.set(cliente);
    }

    public String getProyecto() {
        return (String)this.proyecto.get();
    }

    public StringProperty proyectoProperty() {
        return this.proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto.set(proyecto);
    }

    public String getFecha() {
        return (String)this.fecha.get();
    }

    public StringProperty fechaProperty() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String toString() {
        return "Cliente: " + this.id.get() + " - " + (String)this.cliente.get();
    }
}
