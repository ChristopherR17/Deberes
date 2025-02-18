package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercici0201 {

    public static Scanner scanner;
    public static Locale defaultLocale;

    public static void main(String[] args) {
        
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        /*
        int[] arrEnters = generaArrayEnters(10);
        mostraArrayEstadistiques(arrEnters);

        ArrayList<Integer> lstEnters = generaLlistaEnters(10);
        mostraLlistaEstadistiques(lstEnters);

        filtraArrayParaulesAmbA();
        filtraLlistaParaulesAmbA();

        double[] arrDecimals = generaArrayDecimals(15);
        filtraArrayDecimalsSuperiors50(arrDecimals);

        ArrayList<Double> lstDecimals = generaLlistaDecimals(15);
        filtraLlistaDecimalsSuperiors50(lstDecimals);
        
        HashMap<String, Integer> persones = new HashMap<>();
        persones.put("Anna", 25);
        persones.put("Joan", 30);
        persones.put("Marc", 20);
        mostrarLlistaOrdenadesPerEdat(persones);
        
        mostrarFrecuenciaParaules();
        
        invertirMapaClauValor();
        
        fusionarMapesSumantValors();
        
        ordenarMapaPerClaus();
        */
        HashMap<String, Double> notes = new HashMap<>();
        notes.put("Anna", 7.5);
        notes.put("Joan", 6.8);
        notes.put("Marta", 8.2);
        notes.put("Pere", 4.1);
        notes.put("Enric", 2.0);
        notes.put("Amparo", 6.9);
        notes.put("Olga", 9.0);
        notes.put("Manel", 2.2);
        calcularEstadistiquesNotesEstudiants(notes);
        
        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Genera un array d'enters aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array d'enters amb valors entre 0 i 99
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraArrayEnters
     */
    public static int[] generaArrayEnters(int mida) {
        int[] rst = new int[0];
        return rst;
    }

    /**
     * Calcula i mostra estadístiques d'un array d'enters.
     * 
     * Imprimeix per pantalla l'array, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Array: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     *
     * @param array l'array d'enters sobre el qual calcular les estadístiques
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostraArrayEstadistiques
     */
    public static void mostraArrayEstadistiques(int[] array) {
    }

    /**
     * Genera una llista d'enters aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList d'enters amb valors entre 0 i 99
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraLlistaEnters
     */
    public static ArrayList<Integer> generaLlistaEnters(int mida) {
        ArrayList<Integer> rst = new ArrayList<>();
        return rst;
    }

    /**
     * Calcula i mostra estadístiques d'una llista d'enters.
     * 
     * Imprimeix per pantalla la llista, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Llista: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     * 
     *
     * @param llista la llista d'enters sobre la qual calcular les estadístiques
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostraLlistaEstadistiques
     */
    public static void mostraLlistaEstadistiques(ArrayList<Integer> llista) {

    }

    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a'.
     * 
     * Guarda la llista en un "String[] paraules"
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraArrayParaulesAmbA
     */
    public static void filtraArrayParaulesAmbA() {
        /*
        System.out.println("Escriu 5 paraules separades per ',' o ', ':");
        String words = scanner.nextLine();

        words = words.replace(", ", ",");
        String[] paraules = words.split(",");

        String filtrades = "";
        for (int cnt = 0; cnt < paraules.length; cnt++) {
            String paraula = paraules[cnt];
            if (paraula.toLowerCase().startsWith("a")){
                if (filtrades.length()<1){
                    filtrades = paraula;
                }else{
                    filtrades = filtrades+", "+paraula;
                }
            }
        }
        System.out.println("Paraules que comencen amb 'a':" + filtrades);
        */
    }
       
    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a' en una sola línia separades per ", ".
     * 
     * Guarda la llista en un "ArrayList<String> paraules".
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraLlistaParaulesAmbA
     */
    public static void filtraLlistaParaulesAmbA() {
        System.out.println("Escriu 5 paraules separades per ',' o ', ':");
        String words = scanner.nextLine();

        words = words.replace(", ", ",");
        String[] paraules = words.split(",");
        ArrayList<String> arr = new ArrayList<String>(Arrays.asList(paraules));

        String filtrades = "";
        for (String paraula : arr) {
            if (paraula.toLowerCase().startsWith("a")){
                if (arr.size()<1){
                    filtrades = paraula;
                }
                else{
                    filtrades = filtrades+", "+paraula;
                }
            }
        }

        System.out.println("Paraules que comencen amb 'a':" + filtrades);
    }

    /**
     * Genera un array de decimals aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array de decimals amb valors entre 0.0 i 100.0
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraArrayDecimals
     */
    public static double[] generaArrayDecimals(int mida) {
        
        double[] rst = new double[0];
        
        for (int cnt = 0; cnt < mida; cnt++) {
            Random rd = new Random();
            rst[cnt] = rd.nextDouble(100);
        }
        
        return rst;
        
    }

    /**
     * Genera una llista de decimals aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList de decimals amb valors entre 0.0 i 100.0
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraLlistaDecimals
     */
    public static ArrayList<Double> generaLlistaDecimals(int mida) {
        ArrayList<Double> rst = new ArrayList<>();
        for (int cnt = 0; cnt < mida; cnt++) {
            Random rd = new Random();
            rst.add(rd.nextDouble(100));
        }
        return rst;
    }

    /**
     * Filtra i mostra els decimals superiors a 50 d'un array.
     * 
     * Imprimeix per pantalla l'array original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Array original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     * 
     *
     * @param decimals l'array de decimals a filtrar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraArrayDecimalsSuperiors50
     */
    public static void filtraArrayDecimalsSuperiors50(double[] decimals) {
        String array = "";
        String valors = "";

        for (int i = 0; i < decimals.length; i++) {
            array += String.format("%.2f, ", decimals[i]);
        }
        array = array.substring(0, array.length() - 2) + "]";

        for (int j = 0; j < decimals.length; j++) {
            if (decimals[j] > 50) {
                valors += String.format("%.2f, ", decimals[j]);
            }
        }

        valors = valors.substring(0, valors.length() - 2) + "]";

        System.out.println("Array original: [" + array);
        System.out.println("Valors majors que 50: [" +valors);
    }

    /**
     * Filtra i mostra els decimals superiors a 50 d'una llista.
     * 
     * Imprimeix per pantalla la llista original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Llista original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     *
     * @param decimals la llista de decimals a filtrar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraLlistaDecimalsSuperiors50
     */
    public static void filtraLlistaDecimalsSuperiors50(ArrayList<Double> decimals) {
        String array = "";
        String valors = "";

        for (int i = 0; i < decimals.size(); i++) {
            array += String.format("%.2f, ", decimals.get(i));
        }
        array = array.substring(0, array.length() - 2) + "]";

        for (int j = 0; j < decimals.size(); j++) {
            if (decimals.get(j) > 50) {
                valors += String.format("%.2f, ", decimals.get(j));
            }
        }

        System.out.println("Array original: [" + array);
        System.out.println("Valors majors que 50: [" +valors);
    }
    
    /**
     * Mostra per pantalla les persones ordenades per edat.
     * 
     * Recorre un HashMap de persones (nom i edat) i imprimeix cada persona en format "Nom (Edat)"
     * ordenat per edat de manera ascendent.
     *
     * @param persones un HashMap on la clau és el nom de la persona i el valor és la seva edat
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostrarLlistaOrdenadesPerEdat
     */
    public static void mostrarLlistaOrdenadesPerEdat(HashMap<String, Integer> persones) {
        ArrayList<String> claus = new ArrayList<>(persones.keySet());

        claus.sort((p1, p2) -> {
            Integer a = persones.get(p1);
            Integer b = persones.get(p2);
            return a.compareTo(b);
        });

        for (String clau : claus) {
            System.out.println(clau + " (" + persones.get(clau) + ")");
        }
    }

    /**
     * Demana a l'usuari que introdueixi una frase i mostra la freqüència de cada paraula.
     * 
     * L'usuari escriu una frase per la consola i el mètode separa les paraules usant els espais.
     * A continuació, es calcula la freqüència de cada paraula i es mostra per pantalla en format de HashMap.
     * 
     * 
     * Es mostra per pantalla:
     * "Introdueix una frase:" i després "Freqüència de paraules: {paraula=frequencia, ...}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostrarFrecuenciaParaules
     */
    public static void mostrarFrecuenciaParaules() {
        System.out.println("Introdueix una frase: ");
        String frase = scanner.nextLine();
        
        String[] paraules = frase.split(" ");
        HashMap<String, Integer> freq = new HashMap<>();
        for (String paraula : paraules) {
            if (freq.containsKey(paraula)) {
                freq.put(paraula, freq.get(paraula) + 1);
            } else {
                freq.put(paraula, 1);
            }
        }
        System.out.println("Freqüència de paraules: " + freq);
        
    }

    /**
     * Inverteix un HashMap intercanviant claus i valors.
     * 
     * Es crea un HashMap amb elements (A=1, B=2, C=3) i es construeix un nou HashMap on cada valor 
     * es converteix en clau i cada clau es converteix en valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa original: {A=1, B=2, C=3}" i "Mapa invertit: {1=A, 2=B, 3=C}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testInvertirMapaClauValor
     */
    public static void invertirMapaClauValor() {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("A", 1);
        mapa.put("B", 2);
        mapa.put("C", 3);

        HashMap<Integer, String> reverse = new HashMap<>();
        ArrayList<String> claus = new ArrayList<>(mapa.keySet());
        for (String clau : claus) {
            reverse.put(mapa.get(clau), clau);
        }

        System.out.println("Mapa original: " + mapa);
        System.out.println("Mapa invertit: " + reverse);
    }

    /**
     * Fusiona dos HashMap sumant els valors de les claus comuns.
     * 
     * Es defineixen dos mapes:
     * <ul>
     *   <li>Mapa 1: {X=10, Y=20}</li>
     *   <li>Mapa 2: {Y=5, Z=15}</li>
     * </ul>
     * El mètode crea un nou HashMap on, per cada clau existent en ambdós mapes, es suma el valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa fusionat: {X=10, Y=25, Z=15}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFusionarMapesSumantValors
     */
    public static void fusionarMapesSumantValors() {
        HashMap<String, Integer> mapa1 = new HashMap<>();
        mapa1.put("X", 10);
        mapa1.put("Y", 20);
        HashMap<String, Integer> mapa2 = new HashMap<>();
        mapa2.put("Y", 5);
        mapa2.put("Z", 15);

        HashMap<String, Integer> fusionMap = new HashMap<>(mapa1);
        for (String clau : mapa2.keySet()) {
            if (fusionMap.containsKey(clau)){
                fusionMap.put(clau, fusionMap.get(clau) + mapa2.get(clau));
            }
            else{
                fusionMap.put(clau, mapa2.get(clau));
            }
        }
        System.out.println("Mapa fusionat: " + fusionMap);
    }

    /**
     * Ordena un HashMap per les claus mitjançant un TreeMap i mostra el resultat.
     * 
     * Es crea un HashMap amb elements (Banana=3, Poma=5, Taronja=2) i es transfereix a un TreeMap
     * per obtenir un ordre natural de les claus (alfabètic).
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa ordenat per claus: {Banana=3, Poma=5, Taronja=2}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testOrdenarMapaPerClaus
     */
    public static void ordenarMapaPerClaus() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Banana", 3);
        map.put("Poma", 5);
        map.put("Taronja", 2);

        ArrayList<String> claus = new ArrayList<>(map.keySet());
        claus.sort((p1, p2) -> map.get(p1).compareTo(map.get(p2)));

        HashMap<String, Integer> mapa2 = new HashMap<>();

        System.out.println("Mapa ordenat per claus: "+map);
    }

    /**
     * Calcula i mostra les estadístiques (mitjana, màxim i mínim) de les notes dels estudiants.
     * 
     * Es defineix un HashMap on la clau és el nom de l'estudiant i el valor la seva nota.
     * El mètode calcula la mitjana, la nota màxima i la nota mínima i les mostra per pantalla.
     * 
     * 
     * Es mostra per pantalla:
     * "Mitjana: [valor], Màxim: [valor], Mínim: [valor]".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testCalcularEstadistiquesNotesEstudiants
     */
    public static void calcularEstadistiquesNotesEstudiants(HashMap<String, Double> notes) {
        Double suma=0.0;
        Double mitjana=0.0;
        Double max = Double.MIN_VALUE;
        Double min = Double.MAX_VALUE;

        for (Double nota : notes.values()) {
            suma += nota;
            if (max < nota) max = nota;
            if (min > nota) min = nota;
        }

        mitjana = suma/notes.size();
        System.out.println("Mitjana: " + String.format("%.2f", mitjana) + ", Màxim: " + max + ", Mínim: " + min);
        //Esta es otra opcion -> System.out.printf("Mitjana: %.2f, Màxim: %.2f, Mínim: %.2f%n", mitjana, max, min);
        //Con el printf, primero escribimos el mensaje con el formato y despues las variables
    }
}
