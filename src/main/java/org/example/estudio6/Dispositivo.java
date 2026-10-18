package org.example.estudio6;

import javafx.beans.property.*;

public class Dispositivo {

    private DoubleProperty codigo = new SimpleDoubleProperty(this, "codigo", 0);
    private StringProperty nombre = new SimpleStringProperty(this, "nombre", "");
    private StringProperty tipo = new SimpleStringProperty(this, "tipo", "");
    private DoubleProperty brillo = new SimpleDoubleProperty(this, "brillo", 0.0);

    public Dispositivo(Double codigo, String nombre, String tipo, Double brillo) {
        setCodigo(codigo);
        setNombre(nombre);
        setTipo(tipo);
        setBrillo(brillo);
    }

    public double getCodigo() {
        return codigo.get();
    }

    public DoubleProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo.set(codigo);
    }

    public void setCodigo(int codigo) {
        this.codigo.set(codigo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public double getBrillo() {
        return brillo.get();
    }

    public DoubleProperty brilloProperty() {
        return brillo;
    }

    public void setBrillo(double brillo) {
        this.brillo.set(brillo);
    }

    public String getTipo() {
        return tipo.get();
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }
}
