package com.exercici0602;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.utils.UtilsViews;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerPokeForm implements Initializable{

    @FXML
    private Label labelSaved = new Label();
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
    private TextField fieldHeight;
    @FXML
    private ImageView imgPokemon;

    @FXML
    private ChoiceBox choiceType = new ChoiceBox();

    final String[] pokemonsTypes = {"Planta/Verí", "Foc", "Foc/Volador", "Aigua", "Insecte", "Insecte/Volador", "Insecte/Verí", "Elèctric"};

    @FXML
    private Button buttonAdd = new Button();
    @FXML
    private Button buttonUpdate = new Button();

    @FXML
    private Button buttonDelete = new Button();

    @FXML
    private Button buttonSelectFile = new Button();

    public static final String STATUS_ADD = "add";
    public static final String STATUS_EDIT = "edit";

    private String status = "";
    private int number = -1;

    private String imagePath = "";

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

        choiceType.getItems().clear();
        choiceType.getItems().addAll(Arrays.asList(pokemonsTypes));

        labelSaved.setVisible(false);

        if (this.status.equalsIgnoreCase(STATUS_ADD)) {
            buttonDelete.setVisible(false);
            buttonAdd.setVisible(true);
            buttonUpdate.setVisible(false);

            fieldWeight.clear();
            fieldAbility.clear();
            fieldCategory.clear();
            fieldName.clear();
            choiceType.getSelectionModel().select(pokemonsTypes[0]);
            fieldHeight.clear();
            imgPokemon.setImage(null);
            this.imagePath = "";
        } 

        if (this.status.equalsIgnoreCase(STATUS_EDIT)) {
            buttonDelete.setVisible(true);
            buttonAdd.setVisible(false);
            buttonUpdate.setVisible(true);

            AppData db = AppData.getInstance();
            ArrayList<HashMap<String, Object>> llista = db.query(String.format("SELECT * FROM pokemons WHERE number = '%d';", this.number));
            if (llista.size() == 1) {
                HashMap<String, Object> pokemon = llista.get(0);

                String name = (String) pokemon.get("name");
                String numName = "#" + this.number + " " + name;

                fieldAbility.setText((String) pokemon.get("ability"));
                choiceType.getSelectionModel().select((String) pokemon.get("type"));
                fieldWeight.setText((String) pokemon.get("weight"));
                fieldHeight.setText((String) pokemon.get("height"));
                fieldCategory.setText((String) pokemon.get("category"));
                fieldName.setText(numName);

                try {
                    this.imagePath = (String) pokemon.get("image");
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
    public void add(ActionEvent event){
        String name = fieldName.getText();
        String type = (String) choiceType.getSelectionModel().getSelectedItem();
        String ability = fieldAbility.getText();
        String weight = fieldWeight.getText();
        String height = fieldHeight.getText();
        String category = fieldCategory.getText();
        String image = this.imagePath;

        AppData db = AppData.getInstance();
        String sql = String.format(
            "INSERT INTO pokemons (name, type, ability, weight, height, category, image) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
            name, type, ability, weight, height, category, image
        );
        db.update(sql);

        setStatus(STATUS_ADD, -1);

        labelSaved.setVisible(true);
        delayCode(2500, () -> {
            labelSaved.setVisible(false);
        });
    }

    @FXML
    public void update(ActionEvent event) {
        
        String name = fieldName.getText();
        String type = (String) choiceType.getSelectionModel().getSelectedItem();
        String ability = fieldAbility.getText();
        String weight = fieldWeight.getText();
        String height = fieldHeight.getText();
        String category = fieldCategory.getText();
        String image = this.imagePath;

        AppData db = AppData.getInstance();
        String sql = String.format(
            "UPDATE pokemons SET name = '%s', type = '%s', ability = '%s', weight = '%s', height = '%s', category = '%s', image = '%s' WHERE number = %d;",
            name, type, ability, weight, height, category, image, this.number
        );
        db.update(sql);

        labelSaved.setVisible(true);
        delayCode(2500, () -> {
            labelSaved.setVisible(false);
        });
    }

    @FXML
    public void selectFile(ActionEvent event){
        Stage stage = (Stage) buttonSelectFile.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imatges", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            String fileName = selectedFile.getName(); 
            String destination = System.getProperty("user.dir") + "/data/pokeImages/" +fileName;
            File destinationFile = new File(destination);
            
            try {
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                this.imagePath = "data/pokeImages/" +fileName;

                File file = new File(this.imagePath);
                Image image = new Image(file.toURI().toString());
                this.imgPokemon.setImage(image);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }

    private void delayCode(int milliseconds, Runnable task) {
        Timer timer = new Timer();
        timer.schedule(
            new TimerTask() {
                @Override
                public void run() {
                    task.run();
                }
            }, milliseconds
        );
    }

    @FXML
    public void goBack(MouseEvent event) {
        if (this.status.equalsIgnoreCase(STATUS_ADD)) {
            ControllerPokeList ctrl = (ControllerPokeList) UtilsViews.getController("ViewList");
            ctrl.loadList();
            UtilsViews.setViewAnimating("ViewList");
        } 

        if (this.status.equalsIgnoreCase(STATUS_EDIT)) {
            ControllerPokeList ctrl2 = (ControllerPokeList) UtilsViews.getController("ViewList");
            ctrl2.loadList();
            ControllerPokeCard ctrl = (ControllerPokeCard) UtilsViews.getController("ViewCard");
            ctrl.loadPokemon(this.number);
            UtilsViews.setViewAnimating("ViewCard");
        }
    }

    @FXML
    public void delete (ActionEvent event) {
        AppData db = AppData.getInstance();
        String sql = String.format("DELETE FROM pokemons WHERE number = %d;", this.number);
        db.update(sql);

        fieldWeight.clear();
        fieldAbility.clear();
        fieldCategory.clear();
        fieldName.clear();
        choiceType.getSelectionModel().select(pokemonsTypes[0]);
        fieldHeight.clear();
        imgPokemon.setImage(null);
    }
}