package com.exercici0306;

public class Carrega {

    protected String descripcio;
    protected Double pes;

    public Carrega(String descripcio, Double pes) {
        this.descripcio = descripcio;
        this.pes = pes;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Double getPes() {
        return pes;
    }

    public void setPes(Double pes) {
        this.pes = pes;
    }

    @Override
    public String toString() {
        return "Carrega[descripcio=" + descripcio + ", pes=" + pes + "]";
    }
}
