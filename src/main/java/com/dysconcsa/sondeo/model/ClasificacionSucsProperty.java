package com.dysconcsa.sondeo.model;

import javafx.beans.property.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ClasificacionSucsProperty {

    private final DoubleProperty profundidad;
    private final IntegerProperty limiteLiquido;
    private final IntegerProperty indicePlasticidad;
    private final ObjectProperty<SuelosProperty> tipoSuelo;
    private final StringProperty descripcion;
    private final ObjectProperty<IndexedColors> color;
    private final ObjectProperty<FillPatternType> pattern;

    public ClasificacionSucsProperty() {
        profundidad = new SimpleDoubleProperty();
        limiteLiquido = new SimpleIntegerProperty();
        indicePlasticidad = new SimpleIntegerProperty();
        tipoSuelo = new SimpleObjectProperty<>();
        descripcion = new SimpleStringProperty("");
        color = new SimpleObjectProperty<>();
        pattern = new SimpleObjectProperty<>() ;
    }

    public ClasificacionSucsProperty(Double profundidad, Integer limiteLiquido,
                                     Integer indicePlasticidad, SuelosProperty tipoSuelo,
                                     String descripcion, IndexedColors color,
                                     FillPatternType patternType) {
        this.profundidad = new SimpleDoubleProperty(profundidad);
        this.limiteLiquido = new SimpleIntegerProperty(limiteLiquido);
        this.indicePlasticidad = new SimpleIntegerProperty(indicePlasticidad);
        this.tipoSuelo = new SimpleObjectProperty<>(tipoSuelo);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.color = new SimpleObjectProperty<>(color);
        this.pattern = new SimpleObjectProperty<>(patternType);
    }

    public String getDescripcion() {
        return this.descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
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

    public int getLimiteLiquido() {
        return this.limiteLiquido.get();
    }

    public IntegerProperty limiteLiquidoProperty() {
        return this.limiteLiquido;
    }

    public void setLimiteLiquido(int limiteLiquido) {
        this.limiteLiquido.set(limiteLiquido);
    }

    public int getIndicePlasticidad() {
        return this.indicePlasticidad.get();
    }

    public IntegerProperty indicePlasticidadProperty() {
        return this.indicePlasticidad;
    }

    public void setIndicePlasticidad(int indicePlasticidad) {
        this.indicePlasticidad.set(indicePlasticidad);
    }

    public SuelosProperty getTipoSuelo() {
        return this.tipoSuelo.get();
    }

    public ObjectProperty<SuelosProperty> tipoSueloProperty() {
        return this.tipoSuelo;
    }

    public void setTipoSuelo(SuelosProperty tipoSuelo) {
        this.tipoSuelo.set(tipoSuelo);
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
        return "ClasificacionSucsProperty{profundidad=" + this.profundidad + ", limiteLiquido=" + this.limiteLiquido + ", indicePlasticidad=" + this.indicePlasticidad + ", descripcion=" + this.descripcion + '}';
    }
}
