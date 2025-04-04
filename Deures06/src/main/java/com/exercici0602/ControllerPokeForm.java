package com.exercici0602;

import com.utils.*;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.scene.input.MouseEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;

public class ControllerPokeForm implements Initializable{

    @FXML
    private ImageView imgBackArrow;

    @FXML
    private TextField fieldWeight;
    @FXML
    private TextField fieldAbility;
    @FXML
    private TextField fieldCategory;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldType;
    @FXML
    private TextField fieldHeight;
    @FXML
    private ImageView imgPokemon;

    @FXML
    private Button buttonAdd = new Button();
    @FXML
    private Button buttonUpdate = new Button();

    public static final String STATUS_ADD = "add";
    public static final String STATUS_EDIT = "edit";

    private String status = "";
    private int number = -1;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Path imagePath = null;
        try {
            URL imageURL = getClass().getResource("/assets/images0602/arrow-back.png");
            Image image = new Image(imageURL.toExternalForm());
            imgBackArrow.setImage(image);
        } catch (Exception e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void setStatus(String value, int number){
        this.status = value;
        this.number = number;
        if (this.status.equalsIgnoreCase(STATUS_ADD)) {
            buttonAdd.setVisible(true);
            buttonUpdate.setVisible(false);

            fieldWeight.clear();
            fieldAbility.clear();
            fieldCategory.clear();
            fieldName.clear();
            fieldType.clear();
            fieldHeight.clear();
        } 

        if (this.status.equalsIgnoreCase(STATUS_EDIT)) {
            buttonAdd.setVisible(false);
            buttonUpdate.setVisible(true);

            AppData db = AppData.getInstance();
            ArrayList<HashMap<String, Object>> llista = db.query(String.format("SELECT * FROM pokemons WHERE number = '%d';", this.number));
            if (llista.size() == 1) {
                HashMap<String, Object> pokemon = llista.get(0);

                String name = (String) pokemon.get("name");
                String numName = "#" + String.valueOf(this.number) + " " + name;

                fieldAbility.setText((String) pokemon.get("type"));
                fieldType.setText((String) pokemon.get("ability"));
                fieldWeight.setText((String) pokemon.get("weight"));
                fieldHeight.setText((String) pokemon.get("height"));
                fieldCategory.setText((String) pokemon.get("category"));
                fieldName.setText(numName);

                try {
                    String imagePath = (String) pokemon.get("image");
                    Image image = new Image("file:" + imagePath);
                    imgPokemon.setImage(image);
                } catch (Exception e) {
                    System.err.println("Error loading image asset: " + (String) pokemon.get("image"));
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void selectFile(ActionEvent event){

    }

    @FXML
    public void add(ActionEvent event){

    }

    @FXML
    public void update(ActionEvent event){

    }

    @FXML
    public void goBack(MouseEvent event) {
        if (this.status.equalsIgnoreCase(STATUS_ADD)) {
            UtilsViews.setViewAnimating("ViewList");
        } 

        if (this.status.equalsIgnoreCase(STATUS_EDIT)) {
            UtilsViews.setViewAnimating("ViewCard");
        }
    }
}