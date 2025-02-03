package com.exercici0301;

public class ControlTemperatura {

    private static Double temperaturaTotal = 0.0;
    private static int comptadorZones = 0;
    private String nomZona;
    private Double temperatura;

    public ControlTemperatura(String nomZona, double temperatura) {
        this.nomZona = nomZona;
        this.temperatura = temperatura;
        this.temperaturaTotal += this.temperatura;
        this.comptadorZones++;
    }
    
    public String getNomZona() {
        return nomZona;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void ajustaTemperatura(double novaTemperatura) {
        this.temperaturaTotal -= this.temperatura;
        this.temperatura = novaTemperatura;
        this.temperaturaTotal += novaTemperatura;
    }

    public static double getTemperaturaMitjana() {
        if (comptadorZones>0){
            return temperaturaTotal/comptadorZones;
        }
        return 0.0;
    }
}

