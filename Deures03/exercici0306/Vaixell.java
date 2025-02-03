package com.exercici0306;

import java.util.ArrayList;

public class Vaixell implements Transportable {

    protected String nom;
    protected Double capacitat;
    protected ArrayList<Carrega> carregues;

    double pesTotal = 0.0;

    public Vaixell(String nom, double capacitat) {
        this.nom = nom;
        this.capacitat = capacitat;
        this.carregues = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(Double capacitat) {
        this.capacitat = capacitat;
    }

    public void afegirCarrega(Carrega c) {
        carregues.add(c);
    }

    public ArrayList<Carrega> getCarregues() {
        return carregues;
    }

    @Override
    public double getPesTotal() {
        return carregues.stream().mapToDouble(Carrega::getPes).sum();
    }

    @Override
    public String toString() {
        return "Vaixell[nom=" + nom +", capacitat=" + capacitat + ", pesActual=" + getPesTotal() +"]";
    }
}
