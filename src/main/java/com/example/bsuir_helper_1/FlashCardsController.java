package com.example.bsuir_helper_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Objects;

public class FlashCardsController {
    @FXML
    public Tab nameOfTopic;

    @FXML
    private Text food;

    @FXML
    private Text classes;

    @FXML
    private TextField newNameOfTab;

    @FXML
    private TextField addNew;

    @FXML
    private AnchorPane mainWindowBackground;

    @FXML
    private AnchorPane settingsWindowBackground;

    @FXML
    private AnchorPane nameOfTabBackground;

    @FXML
    private AnchorPane addNewBackground;

    @FXML
    private AnchorPane listBackground;

    final public String [] listOfFood = new String[] {"сталовка 4к","сталовка 2к","буфет 4к","буфет 5к","церковная лавка","продукты бар","корона","буфут 2к"};
    final public int numberOfFood = Array.getLength(listOfFood);
    final public String [] listOfClasses = new String[] {"лабы/учеба","фильмец","накотить встречу с друзьями","прогуляться по улице","погамать в компик","заняться свои хобби"};
    final public int numberOfClasses = Array.getLength(listOfClasses);

    public String [] listOfNewFlashcards = new String[15];
    public int numOfNewFlashcards = 0;

    public void generateNewPlace(){
        int newRandFood = (int) (Math.random() *numberOfFood);
        food.setText(listOfFood[newRandFood]);

    }

    public void generateNewClasses(){
        int newRandClasses = (int) (Math.random() *numberOfClasses);
        classes.setText(listOfClasses[newRandClasses]);
    }

    /*public void ChangeNameOfTab(){
        SettingsChangeNameOfTab.setNameOfTab();
    }*/



    public void settings(){
    mainWindowBackground.setVisible(false);
    settingsWindowBackground.setVisible(true);
    }

    public void closeButton(){
        settingsWindowBackground.setVisible(false);
        mainWindowBackground.setVisible(true);
    }

    public void saveButton(){
        if (!Objects.equals(newNameOfTab.getText(), ""))
        nameOfTopic.setText(newNameOfTab.getText());
        if (numOfNewFlashcards>14){
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Warning!");
            window.setMinWidth(300);
            window.setMinHeight(100);

            Text WarningText = new Text("The limit flash-cards is exceeded");
            Button okWarningButton = new Button("ok");
            okWarningButton.setOnAction(e -> window.close());

            VBox layout = new VBox(2);
            layout.getChildren().addAll(WarningText,okWarningButton);
            layout.setAlignment(Pos.CENTER);

            Scene SceneOfChangeTab = new Scene(layout);
            window.setScene(SceneOfChangeTab);
            window.show();
        }
        else{
            listOfNewFlashcards[numOfNewFlashcards] = addNew.getText();
            numOfNewFlashcards++;
        }
    }

    public void nameOfTabButton(){
        nameOfTabBackground.setVisible(true);
        addNewBackground.setVisible(false);
        listBackground.setVisible(false);
    }

    public void addNewButton(){
        nameOfTabBackground.setVisible(false);
        addNewBackground.setVisible(true);
        listBackground.setVisible(false);
    }

    public void listOfFlashcardsButton(){
        nameOfTabBackground.setVisible(false);
        addNewBackground.setVisible(false);
        listBackground.setVisible(true);
    }

    public void BackToMenuFlashCards(final ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("BSUIR HELPER");
        stage.setScene(scene);
        stage.show();
    }
}
