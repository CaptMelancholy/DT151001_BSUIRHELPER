package com.example.bsuir_helper_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Objects;

public class FlashCardsController {
    @FXML
    public Tab NameOfTopic;

    @FXML
    private Text Food;

    @FXML
    private Text Classes;

    final public String [] ListOfFood = new String[] {"сталовка 4к","сталовка 2к","буфет 4к","буфет 5к","церковная лавка","продукты бар","корона","буфут 2к"};
    final public int NumberOfFood = Array.getLength(ListOfFood);
    final public String [] ListOfClasses = new String[] {"лабы/учеба","фильмец","накотить встречу с друзьями","прогуляться по улице","погамать в компик","заняться свои хобби"};
    final public int NumberOfClasses = Array.getLength(ListOfClasses);

    public void GenerateNewPlace(ActionEvent event){
        int NewRandFood = (int) (Math.random() *NumberOfFood);
        Food.setText(ListOfFood[NewRandFood]);

    }
    public void GenerateNewClasses(final ActionEvent event){
        int NewRandClasses = (int) (Math.random() *NumberOfClasses);
        Classes.setText(ListOfClasses[NewRandClasses]);
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
