package com.exercicis;


public class Exercici0005 {

    public static boolean isPalindrom(String text) {
        text = normalize(text);
        
        int lastLetter = text.length() - 1;
        String inverted = "";
        for (int cnt = lastLetter; cnt >= 0; cnt = cnt - 1) {
            String letter = String.valueOf(text.charAt(cnt));
            inverted = inverted + letter;
        }

        return text.equals(inverted);
    }

    public static String normalize(String text) {
        text = text.toLowerCase();
        
        String[] especial = {"à", "á", "è", "é", "í", "ò", "ó", "ú", "ù", " ", "'", "!", "\\.", ",", "·"};
        String[] noEspecial = {"a", "a", "e", "e", "i", "o", "o", "u", "u", "", "", "", "", "", ""};

        for (int i = 0; i < especial.length; i++) {
            text = text.replaceAll(especial[i], noEspecial[i]);
        }

        return text;
    }
   
    public static void main(String[] args) {
        String[] frases = {
            "Anul·la la lluna",
            "Atrapa la lluna",
            "Atrapa'l o l'aparta",
            "Aparta'l o atrapa'l",
            "No sap pas on",
            "On sap pas qui",
            "Tramaran anar a Mart",
            "A Mart trobaràn art",
            "Un pop nu",
            "Nu pop un"
        };

        for (String frase : frases) {
            if (isPalindrom(frase) == true){
                System.out.println(frase+" (Si)");
            }
            else{
                System.out.println(frase+" (No)");
            }
        }
    }
}
