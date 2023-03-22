package com.example.conversordedivisas;

public class Divisas {

    private String nombre, conversion, codigo, simbolo;

    public Divisas(String nombre, String conversion, String codigo, String simbolo) {
        this.nombre = nombre;
        this.conversion = conversion;
        this.codigo = codigo;
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
