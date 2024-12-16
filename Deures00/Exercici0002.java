package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;

        System.out.println("Escriu el valor en Euros: ");
        Double euros = scanner.nextDouble();

        System.out.println("Escriu la tasa de conversió (ex: 1.25): ");
        Double tasa = scanner.nextDouble();

        Double dollars = euros * tasa;

        System.out.printf(localeUS, "El valor de %.2f€ són %.2f$%n", euros, dollars);

        scanner.close();
    }
}
