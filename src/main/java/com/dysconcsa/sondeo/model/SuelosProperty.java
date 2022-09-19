//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.model;

import javafx.beans.property.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.Objects;

public class SuelosProperty {

    private final IntegerProperty ID;
    private final StringProperty nombre;
    private final StringProperty simbolo;
    private final ObjectProperty<IndexedColors> color;
    private final ObjectProperty<FillPatternType> pattern;

    public SuelosProperty(Integer ID, String name, String symbol, IndexedColors colors, FillPatternType patternType) {
        this.ID = new SimpleIntegerProperty(ID);
        this.nombre = new SimpleStringProperty(name);
        this.simbolo = new SimpleStringProperty(symbol);
        this.color = new SimpleObjectProperty<>(colors);
        this.pattern = new SimpleObjectProperty<>(patternType);
    }

    public int getID() {
        return this.ID.get();
    }

    public IntegerProperty IDProperty() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getNombre() {
        return (String)this.nombre.get();
    }

    public StringProperty nombreProperty() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getSimbolo() {
        return (String)this.simbolo.get();
    }

    public StringProperty simboloProperty() {
        return this.simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo.set(simbolo);
    }

    public IndexedColors getColor() {
        return (IndexedColors)this.color.get();
    }

    public ObjectProperty<IndexedColors> colorProperty() {
        return this.color;
    }

    public void setColor(IndexedColors color) {
        this.color.set(color);
    }

    public FillPatternType getPattern() {
        return (FillPatternType)this.pattern.get();
    }

    public ObjectProperty<FillPatternType> patternProperty() {
        return this.pattern;
    }

    public void setPattern(FillPatternType pattern) {
        this.pattern.set(pattern);
    }

    public String toString() {
        return this.simbolo.get();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            SuelosProperty that = (SuelosProperty)o;
            return Objects.equals(this.ID, that.ID) && Objects.equals(this.nombre, that.nombre) && Objects.equals(this.simbolo, that.simbolo);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.ID, this.nombre, this.simbolo});
    }
}
