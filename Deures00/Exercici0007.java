package com.exercicis;

import java.util.Locale;

public class Exercici0007 {

    public static double calculaCostLloc(String tipusLloc) {
        if (tipusLloc.equalsIgnoreCase("sala estàndard")){
            return 100.0;
        }
        else if (tipusLloc.equalsIgnoreCase("jardí amb piscina")){
            return 200.0;
        }
        else if (tipusLloc.equalsIgnoreCase("saló gran amb escenari")){
            return 500.0;
        }
        else{
            throw new IllegalArgumentException("Tipus de lloc desconegut: " + tipusLloc);
        }
    }

    public static double calculaCostMenjar(String tipusMenjar, int numConvidats) {
        Double precioMenjar = 0.0;

        if (tipusMenjar.equalsIgnoreCase("menú bàsic")){
            precioMenjar = numConvidats*15.0;
        }else if (tipusMenjar.equalsIgnoreCase("menú premium")){
            precioMenjar = numConvidats*30.0;
        }else{
            throw new IllegalArgumentException("Tipus de menú desconegut: " + tipusMenjar);
        }

        if (numConvidats>50){
            Double descuento = precioMenjar*(5.0/100);
            precioMenjar -= descuento;
        }

        return precioMenjar;
    }

    public static double calculaCostEntreteniment(String tipusEntreteniment) {
        Double precioEntreteniment = 0.0;

        if (tipusEntreteniment.equalsIgnoreCase("màgia")){
            precioEntreteniment = 250.0;
        }
        else if (tipusEntreteniment.equalsIgnoreCase("música en directe")){
            precioEntreteniment = 500.0;
        }
        else if (tipusEntreteniment.equalsIgnoreCase("cap")){
            precioEntreteniment = 0.0;
        } 
        else{
            throw new IllegalArgumentException("Tipus d'entreteniment desconegut: " + tipusEntreteniment);
        }

        return precioEntreteniment;
    }

    public static double calculaFesta(String tipusLloc, String tipusMenjar, String tipusEntreteniment, int numConvidats) {
        Double lloc = calculaCostLloc(tipusLloc);
        Double menjar = calculaCostMenjar(tipusMenjar, numConvidats);
        Double entreteniment = calculaCostEntreteniment(tipusEntreteniment);

        if (tipusLloc.equalsIgnoreCase("saló gran amb escenari") && tipusEntreteniment.equalsIgnoreCase("música en directe")) {
            entreteniment -= 100.0; 
        }

        return lloc + menjar + entreteniment;
    }

    public static void main(String[] args) {
        String template = "%-75s%.2f€";

        System.out.println(String.format(Locale.US, template, "Cas 1 (\"sala estàndard\", \"menú bàsic\", \"cap\", 20):", calculaFesta("sala estàndard", "menú bàsic", "cap", 20)));
        System.out.println(String.format(Locale.US, template, "Cas 2 (\"jardí amb piscina\", \"menú premium\", \"màgia\", 60):", calculaFesta("jardí amb piscina", "menú premium", "màgia", 60)));
        System.out.println(String.format(Locale.US, template, "Cas 3 (\"jardí amb piscina\", \"menú bàsic\", \"música en directe\", 40):", calculaFesta("jardí amb piscina", "menú bàsic", "música en directe", 40)));
        System.out.println(String.format(Locale.US, template, "Cas 4 (\"saló gran amb escenari\", \"menú premium\", \"música en directe\", 70):", calculaFesta("saló gran amb escenari", "menú premium", "música en directe", 70)));
        System.out.println(String.format(Locale.US, template, "Cas 5 (\"sala estàndard\", \"menú premium\", \"màgia\", 15):", calculaFesta("sala estàndard", "menú premium", "màgia", 15)));
    }
}
