package com.exercici0601;

import java.util.Objects;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;

public class ControllerItem {
    
    @FXML
    private Label name;
    @FXML
    private ImageView img;

    @FXML
    private Label year, type;
    @FXML
    private TextArea plot;

    @FXML
    private Label date, procesador, color, units_sold;

    /*Setters generales */
    public void setName(String name) {
        this.name.setText(name);
    }
    public void setImatge(String imagePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            this.img.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    /*Setters de subViewGames */
    public void setYear(String year) {
        this.year.setText(year);
    }
    public void setType(String type) {
        this.type.setText(type);
    }
    public void setPlot(String plot) {
        this.plot.setText(plot);
    }

    /*Setters de subViewConsoles */
    public void setDate(String date){
        this.date.setText(date);
    }
    public void setProcesador(String procesador){
        this.procesador.setText(procesador);
    }
    public void setColor(String color){
        this.color.setText(color);
    }
    public void setUnitsSold(String units_sold){
        this.units_sold.setText(units_sold);
    }
}
