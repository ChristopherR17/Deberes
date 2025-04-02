package com.exercici0602;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import java.util.Objects;

import javafx.scene.control.Label;

public class ControllerItem {
    @FXML
    private Label name, type;
    @FXML
    private ImageView img;

    /*Setters */
    public void setName(String name) {
        this.name.setText(name);
    }
    public void setType(String type) {
        this.type.setText(type);
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
