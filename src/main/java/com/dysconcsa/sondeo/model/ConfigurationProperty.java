//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

import javafx.beans.property.*;

public class ConfigurationProperty {

    private final IntegerProperty id;
    private final StringProperty imagen;
    private final StringProperty nombreEmpresa;
    private final BooleanProperty selected;

    public ConfigurationProperty(Integer id, String nombreEmpresa, String imagen, Boolean selected) {
        this.id = new SimpleIntegerProperty(id);
        this.imagen = new SimpleStringProperty(imagen);
        this.nombreEmpresa = new SimpleStringProperty(nombreEmpresa);
        this.selected = new SimpleBooleanProperty(selected);
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

    public String getImagen() {
        return (String)this.imagen.get();
    }

    public StringProperty imagenProperty() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen.set(imagen);
    }

    public String getNombreEmpresa() {
        return (String)this.nombreEmpresa.get();
    }

    public StringProperty nombreEmpresaProperty() {
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa.set(nombreEmpresa);
    }

    public boolean isSelected() {
        return this.selected.get();
    }

    public BooleanProperty selectedProperty() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public String toString() {
        return (String)this.nombreEmpresa.get();
    }
}
