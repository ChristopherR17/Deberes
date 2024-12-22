package com.exercicis;

import java.util.Scanner;

public class Exercici0004 {

    public static int contaMajuscules(String contrasenya) {
        char[] llista = contrasenya.toCharArray();

        int cnt = 0;

        for (char c : llista) {
            if (Character.isUpperCase(c)){
                cnt++;
            }
        }

        return cnt;
    }

    public static int contaMinuscules(String contrasenya) {
        char[] llista = contrasenya.toCharArray();

        int cnt = 0;

        for (char c : llista) {
            if (Character.isLowerCase(c)){
                cnt++;
            }
        }

        return cnt;
    }

    public static String validaContrasenya(String contrasenya) {
        int min = contaMinuscules(contrasenya);
        int mayus = contaMajuscules(contrasenya);

        int llargada = contrasenya.trim().length();

        if (llargada>8 && min>=2 && mayus>=2){
            return "La contrasenya és vàlida";
        }
        else{
            return "La contrasenya NO és vàlida";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Escriu una contrasenya: ");
        String contrasenya = scanner.nextLine();

        System.out.println("La contrasenya '"+contrasenya+"': "+validaContrasenya(contrasenya));

        scanner.close();
    }
}
