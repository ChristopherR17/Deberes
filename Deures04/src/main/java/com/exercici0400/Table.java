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

        int espacios = (width - txt.length());
        if (align.equalsIgnoreCase("left")){
            return txt + " ".repeat(espacios);
        }
        else if (align.equalsIgnoreCase("center")){
            int aux = espacios%2;
            espacios /= 2;

            return " ".repeat(espacios + aux) + txt + " ".repeat(espacios);            
        }
        else if (align.equalsIgnoreCase("right")){
            return " ".repeat(espacios) + txt;
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

        rst.add(" " + capcelera + " ".repeat((super.width - capcelera.length()-1)));

        String separador="";
        for (int i = 0; i < widths.size(); i++) {
            int width = widths.get(i);
            
            if (i != widths.size()-1) {
                separador = separador + "┼" + "─".repeat(width);
            } else {
                separador = separador + "┼" + "─".repeat(width + (super.width - capcelera.length()-1));
            }
        }
        rst.add(2, separador);
        
        // for (ArrayList<String> row : rows) {
        //     String linia = "";
        //     for (int cntRows = 0; cntRows < row.size(); cntRows++) {
        //         linia += formatRow(row.get(cntRows), widths.get(cntRows), aligns.get(cntRows));
        //         if (cntRows < (headers.size() - 1)) {
        //             linia += "│";
        //         }
        //     }
        //     rst.add(" " + linia + " ".repeat((super.width - linia.length()-1)));
        // }

        for (int i = 3; i < height; i++) {
            if (rst.get(i) != null) {
                String linia = "";

                for (int cntRows = 0; cntRows < rows.get(cntRows).size(); cntRows++) {
                    ArrayList<String> row = rows.get(cntRows);

                    linia += formatRow(row.get(cntRows), widths.get(cntRows), aligns.get(cntRows));
                    if (cntRows < (headers.size() - 1)) {
                        linia += "│";
                    }
                }
                rst.add(i," " + linia + " ".repeat((width - linia.length()-1)));
            }else {
                rst.add(i, " ".repeat(width));
            }
        }

        //Asignar text segons alineació 
        // for (int i = rst.size(); i < height; i++) {
        //     rst.add(i, " ".repeat(width));
        // }
        return rst;

    }
}
