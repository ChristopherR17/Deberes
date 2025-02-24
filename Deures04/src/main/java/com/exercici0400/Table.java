package com.exercici0400;

import java.util.ArrayList;

public class Table extends Component {

    private ArrayList<String> headers;
    private ArrayList<Integer> widths;
    private ArrayList<String> aligns;
    private ArrayList<ArrayList<String>> rows;
    
    public Table(int x, int y, int width, int height, String title, ArrayList<String> headers, ArrayList<Integer> widths, ArrayList<String> aligns, ArrayList<ArrayList<String>> rows) {
        super(x, y, width, height, title);
        this.headers = headers;
        this.widths = widths;
        this.aligns = aligns;
        this.rows = rows;
    }

    private String formatRow(String txt, int width, String align){
        if (txt.length() > width) {
            return txt.substring(0, width);
        }

        if (align.equalsIgnoreCase("left")){
            return txt + " ".repeat(width - txt.length());
        }
        else if (align.equalsIgnoreCase("center")){
            int espacios = (width - txt.length());
            int aux = espacios%2;
            espacios /= 2;

            return " ".repeat(espacios + aux) + txt + " ".repeat(espacios);            
        }
        else if (align.equalsIgnoreCase("right")){
            return " ".repeat(width - txt.length()) + txt;
        }

        return txt;
    }

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();

        // Afegir linia buida al principi
        rst.add(0, " ".repeat(width)); 

        String capcelera = "";
        for (int cntHeader = 0; cntHeader < headers.size(); cntHeader++) {
            capcelera += formatRow(headers.get(cntHeader), widths.get(cntHeader), aligns.get(cntHeader));
            if (cntHeader < (headers.size() - 1)) {
                capcelera += "│";
            }
        }

        rst.add(" " + capcelera + " ");
        rst.add("─".repeat(width));

        
        for (ArrayList<String> row : rows) {
            String linia = "";
            for (int cntRows = 0; cntRows < row.size(); cntRows++) {
                linia += formatRow(row.get(cntRows), widths.get(cntRows), aligns.get(cntRows));
                if (cntRows < (headers.size() - 1)) {
                    linia += "│";
                }
            }
            rst.add(" " + linia + " ");
        }

        // Asignar text segons alineació 
        for (int i = rst.size(); i < height; i++) {
            rst.add(i, "x".repeat(width));
        }
        return rst;
    }

    /*
    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();

        // Afegir linia buida al principi
        rst.add(0, " ".repeat(width)); 

        String capcelera = "";
        for (int cntHeader = 0; cntHeader < headers.size(); cntHeader++) {
            String header = headers.get(cntHeader);
            int width = widths.get(cntHeader);
            String align = aligns.get(cntHeader);

            if (align.equalsIgnoreCase("left")) {
                if (header.length() < width) {
                    capcelera += header + " ".repeat(width - header.length());
                }
            }
            else if (align.equalsIgnoreCase("center")) {
                int espacios = (width - header.length());
                int aux = 0;

                if (espacios%2!=0) {
                    aux += 1;
                }

                espacios /= 2;

                if (header.length() < width) {
                    capcelera += " ".repeat(espacios + aux) + header + " ".repeat(espacios);
                }
            }
            else if (align.equalsIgnoreCase("right")){
                if (header.length() < width) {
                    capcelera += " ".repeat(width - header.length()) + header;
                }
            }

            if(header.length() > width) {
                capcelera += header.substring(0, width);
            }
        
            if (cntHeader < (headers.size() - 1)) {
                capcelera += "│";
            }
        }

        rst.add(1, " " + capcelera + " ");
        rst.add(2, "─".repeat(width));

        for (int i = 0; i < rows.size(); i++) {
            ArrayList<String> row = rows.get(i);
            String linia = "";
            for (int cntRows = 0; cntRows < row.size(); cntRows++) {
                String element = row.get(cntRows);
                int width = widths.get(cntRows);
                String align = aligns.get(cntRows);

                if (align.equalsIgnoreCase("left")) {
                    if (element.length() < width) {
                        linia += element + " ".repeat(width - element.length());
                    }
                }
                else if (align.equalsIgnoreCase("center")) {
                    int espacios = (width - element.length());
                    int aux = 0;

                    if (espacios%2!=0) {
                        aux += 1;
                    }

                    espacios /= 2;

                    if (element.length() < width) {
                        linia += " ".repeat(espacios + aux) + element + " ".repeat(espacios);
                    }
                }
                else if (align.equalsIgnoreCase("right")){
                    if (element.length() < width) {
                        linia += " ".repeat(width - element.length()) + element;
                    }
                }

                if(element.length() > width) {
                    linia += element.substring(0, width);
                }
            
                if (cntRows < (headers.size() - 1)) {
                    linia += "│";
                }
            }
            rst.add(" " + linia + " ");
        }

        // Asignar text segons alineació 
        for (int i = rst.size(); i < height; i++) {
            rst.add(i, "x".repeat(width));
        }
        return rst;
    }  */
}
