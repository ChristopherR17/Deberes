package com.exercici0400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 Estructura ✅
 Components ✅
 Menús
 Text
 Table
 Input
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "";
        String align = "left";
        boolean repetirBucle = true;
        ArrayList<Component> components = new ArrayList<>();

        while (repetirBucle) {

            HashMap<Integer, MenuItem> mapMnu = new HashMap<>();
    
            mapMnu.put(0, new MenuItem("Sortir", new String[] {"sortir", "exit"}));
            mapMnu.put(1, new MenuItem("Esquerra", new String[]{"esquerra", "left"}));
            mapMnu.put(2, new MenuItem("Dreta", new String[]{"dreta", "right"}));
            mapMnu.put(3, new MenuItem("Centrada", new String[]{"centrat", "center"}));
    
            Menu mnu0 = new Menu(0, 0, 20, 8, "Menú", mapMnu, true);
            Text txt1 = new Text(21, 0, 25, 8, "Txt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", 3, false, align);

            components.add(mnu0);
            components.add(txt1);

            Container container = new Container(50, 10, components);
            container.draw();

            System.out.print("Escull una opció: ");
            input = scanner.nextLine();

            int selection = mnu0.getSelection(input);
            switch (selection) {
                case 0:
                    repetirBucle = false;
                    break;
                case 1:
                    align = "left";
                    break;
                case 2:
                    align = "right";
                    break;
                case 3:
                    align = "center";
                    break;
                default:
                    break;
            }
        }
        
        scanner.close();
    }
}