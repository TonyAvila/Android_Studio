package com.example.recyclerview_cardview_ut_2_11;

public class Cartas {
    String imagen, texto, enlace;

    public Cartas(String imagen, String texto, String enlace) {
        this.imagen = imagen;
        this.texto = texto;
        this.enlace = enlace;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
