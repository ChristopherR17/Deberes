package com.exercici0602;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.control.Label;

import com.exercici0602.ControllerItem;

public class ControllerPokeList {
    @FXML
    private VBox list = new VBox();

    public void loadList() {
        AppData db = AppData.getInstance();
        db.connect("./data/pokemons.sqlite");

        ArrayList<HashMap<String, Object>> llistaPokemons = db.query("SELECT * FROM pokemons");
        setList(llistaPokemons);
    }

    private void setList(ArrayList<HashMap<String, Object>> llistaPokemon){
        try {
            list.getChildren().clear();

            URL resource = this.getClass().getResource("/assets/subViewPokemonList.fxml");
            //Llista dels Pokemons
            for (int i = 0; i < llistaPokemon.size(); i++) {
                HashMap<String, Object> pokemon = llistaPokemon.get(i);

                FXMLLoader loader = new FXMLLoader(resource);
                Parent itemTemplate = loader.load();
                ControllerItem itemController = loader.getController();

                String name = (String)pokemon.get("name");
                String type = (String)pokemon.get("type");
                String imagePath = (String)pokemon.get("image");

                itemController.setName(name);
                itemController.setType(type);
                itemController.setImatge(imagePath);

                list.getChildren().add(itemTemplate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addPokemon(ActionEvent event){
        //TODO
    }

}