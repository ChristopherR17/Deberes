package com.exercici0306;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Port {

    private String nom;
    private ArrayList<Vaixell> vaixells;

    public Port(String nom) {
        this.nom = nom;
        this.vaixells = new ArrayList<>();
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String value) {
        this.nom = value;
    }

    public void afegirVaixell(Vaixell v) {
        vaixells.add(v);
    }

    public ArrayList<Vaixell> getVaixells() {
        return vaixells;
    }

    public void printVaixells() {
        for (Vaixell vaixell : vaixells) {
            System.out.println(vaixell);
        }
    }

    public ArrayList<String> validarNormatives() {
        ArrayList<String> rst = new ArrayList<>();
        for (Vaixell vaixell : vaixells) {
            if (vaixell instanceof Reglamentari){
                rst.add(vaixell.nom + " (" + vaixell.getClass().getSimpleName() + "): " +
                    (((Reglamentari) vaixell).compleixNormativa() ? "Normatiu" : "NO normatiu"));
            }
        }
        return rst;
    }

    public void printNormatives() {
        ArrayList<String> normatives = validarNormatives();
        for (String normativa : normatives) {
            System.out.println(normativa);
        }
    }

    @Override
    public String toString() {
        return "Port[nom=" + nom + ", vaixells=" + vaixells.size() + "]";
    }    
}
