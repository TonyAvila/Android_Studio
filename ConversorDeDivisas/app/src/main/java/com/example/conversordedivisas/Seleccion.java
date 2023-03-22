package com.example.conversordedivisas;

import java.util.Objects;

public class Seleccion {
    int divisa;
    String euros;
    int ronda;

    public Seleccion(String euros, int divisa, int ronda) {
        this.euros = euros;
        this.divisa = divisa;
        this.ronda = ronda;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public String getEuros() {
        return this.euros;
    }

    public void setEuros(String euros) {
        this.euros = euros;
    }

    public int getDivisa() {
        return divisa;
    }

    public void setDivisa(int divisa) {
        this.divisa = divisa;
    }

}
