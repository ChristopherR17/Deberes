package com.exercicis;

import java.util.Scanner;

public class Exercici0000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escriu el primer número: ");
        int num1 = scanner.nextInt();

        System.out.println("Escriu el segon número: ");
        int num2 = scanner.nextInt();

        int resultat = num1-num2;

        System.out.println("El resultat de calcular "+num1+" - "+num2+" és "+resultat+"");

        scanner.close();
    }
}
