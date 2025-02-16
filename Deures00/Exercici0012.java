package com.exercicis;

import java.util.*;

public class Exercici0012 {

    public static HashMap<String, Object> createWonder(String name, String location, int age) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("name", name);
        map.put("location", location);
        map.put("age", age);

        return map;
    }

    public static void showInformation(ArrayList<HashMap<String, Object>> wonders) {
        for (HashMap<String, Object> wonder : wonders) {
            System.out.println("* Name: " + wonder.get("name"));
            System.out.println("  Location: " + wonder.get("location"));
            System.out.println("  Age: " + wonder.get("age") + " years");
        }
    }

    public static ArrayList<HashMap<String, Object>> sortWondersByName(ArrayList<HashMap<String, Object>> wonders) {
        ArrayList<HashMap<String,Object>> sorted = new ArrayList<>(wonders);

        sorted.sort((wonder1, wonder2) -> {
            String a = (String) wonder1.get("name");
            String b = (String) wonder2.get("name");
            return a.compareTo(b);
        });

        return sorted;
    }
  
    public static ArrayList<HashMap<String, Object>> getSortedWondersByName(ArrayList<HashMap<String, Object>> wonders, int quantity) {
        ArrayList<HashMap<String, Object>> sortedWonders = sortWondersByName(wonders);
        return new ArrayList<>(sortedWonders.subList(0, Math.min(quantity, sortedWonders.size())));
    }    
   
    public static ArrayList<String> sortNames(ArrayList<HashMap<String, Object>> wonders) {
        ArrayList<HashMap<String, Object>> sortedWonders = getSortedWondersByName(wonders, wonders.size());
        ArrayList<String> names = new ArrayList<>();
        for (HashMap<String, Object> wonder : sortedWonders) {
            names.add((String) wonder.get("name"));
        }
        return names;
    }    

    public static ArrayList<HashMap<String, Object>> getOlder(ArrayList<HashMap<String, Object>> wonders, int quantity) {
        ArrayList<HashMap<String, Object>> sortedWonders = new ArrayList<>(wonders);
    
        sortedWonders.sort((wonder1, wonder2) -> {
            Integer a = (Integer) wonder1.get("age");
            Integer b = (Integer) wonder2.get("age");
            return b.compareTo(a);
        });
    
        return new ArrayList<>(sortedWonders.subList(0, Math.min(quantity, sortedWonders.size())));
    }    
   
    public static ArrayList<HashMap<String, Object>> getRegion(ArrayList<HashMap<String, Object>> wonders, String region) {
        ArrayList<HashMap<String, Object>> resultat = new ArrayList<>();

        for (HashMap<String, Object> wonder : wonders) {
            if (((String) wonder.get("location")).contains(region)) {
                resultat.add(wonder);
            }
        }
        return resultat;
    }

    public static void main(String[] args) {

        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(createWonder("Great Pyramid of Giza", "Egypt", 4500));
        wonders.add(createWonder("Hanging Gardens of Babylon", "Babylon, Mesopotamia", 2500));
        wonders.add(createWonder("Statue of Zeus at Olympia", "Olympia, Greece", 2500));
        wonders.add(createWonder("Temple of Artemis at Ephesus", "Ephesus, Turkey", 2400));
        wonders.add(createWonder("Mausoleum at Halicarnassus", "Halicarnassus, Turkey", 2300));
        wonders.add(createWonder("Colossus of Rhodes", "Island of Rhodes, Greece", 2300));
        wonders.add(createWonder("Lighthouse of Alexandria", "Alexandria, Egypt", 2200));

        System.out.println("All Wonders:");
        showInformation(wonders);

        System.out.println("-".repeat(25));
        System.out.println("Sorted Names:");
        ArrayList<String> sortedNames = sortNames(wonders);
        System.out.println(sortedNames);

        System.out.println("-".repeat(25));
        System.out.println("Top 3 Oldest Wonders:");
        ArrayList<HashMap<String, Object>> oldestWonders = getOlder(wonders, 3);
        showInformation(oldestWonders);

        System.out.println("-".repeat(25));
        System.out.println("Wonders in Turkey:");
        ArrayList<HashMap<String, Object>> turkishWonders = getRegion(wonders, "Turkey");
        showInformation(turkishWonders);
    }
}
