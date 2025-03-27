package com.exercici0601;

import java.util.Objects;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;

public class ControllerItem {
    
    @FXML
    private Label name;
    @FXML
    private ImageView img;

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
}
