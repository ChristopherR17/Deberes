package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercici0011 {

    public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat) {
        if (quantitat > noms.size()) {
            throw new IllegalArgumentException("La quantitat no pot ser més gran que " + noms.size() + ".");
        }

        ArrayList<String> nomsAtzar = new ArrayList<>();
        Random random = new Random();
        ArrayList<String> copia = new ArrayList<>(noms);

        for (int i = 0; i < quantitat; i++) {
            int index = random.nextInt(copia.size());
            nomsAtzar.add(copia.remove(index));
        }

        return nomsAtzar;
    }

    public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms) {
        ArrayList<Character> vocals = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        ArrayList<String> resultat = new ArrayList<>();

        for (String paraula : noms) {
            char lastLetter = paraula.toLowerCase().charAt(paraula.length() - 1);
            if (vocals.contains(lastLetter)) {
                resultat.add(paraula);
            }
        }

        return resultat;
    }

    public static ArrayList<String> nomsCompostos(ArrayList<String> noms) {
        ArrayList<String> compostos = new ArrayList<>();

        for (String paraula : noms) {
            if (paraula.contains(" ")) {
                compostos.add(paraula);
            }
        }

        return compostos;
    }

    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        ));

        ArrayList<String> nomsEscollits = escullNomsAleatoris(noms, 5);
        System.out.println("Noms escollits a l'atzar: " + nomsEscollits);

        try {
            ArrayList<String> nomError = escullNomsAleatoris(noms, 25);
            System.out.println("Noms escollits: " + nomError);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ArrayList<String> vocal = nomsAcabenVocal(noms);
        System.out.println("Noms que acaben amb vocal: " + vocal);

        ArrayList<String> compostos = nomsCompostos(noms);
        System.out.println("Noms compostos: " + compostos);
    }
}
