package com.example.bsuir_helper_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//TODO переписать названия переменных в одном стиле, желательно на одном языке, текста вроде "tema1" быть не должно нигде
public class FlashCardsController {
    @FXML
    private Text eda;

    @FXML
    private Text ideas;

    final public String [] ListOfFood = new String[] {"сталовка 4к","сталовка 2к","буфет 4к","буфет 5к","церковная лавка","продукты бар","корона","буфут 2к","еще что-то"};
    final public int NumberOfFood = Array.getLength(ListOfFood);

    //TODO ужасно, переделать
    public void GenerateNewPlace(ActionEvent event){
        int NewRandFood = (int) (Math.random() *NumberOfFood);
        eda.setText(ListOfFood[NewRandFood]);

    }
    public void GenerateNewClasses(final ActionEvent event){
        //TODO Так переменные не называют
        int rand2 = ThreadLocalRandom.current().nextInt(1, 4);
        //TODO Нет default
        switch (rand2) {
            case (1) -> ideas.setText("tema1");
            case (2) -> ideas.setText("tema2");
            case (3) -> ideas.setText("tema3");
            case (4) -> ideas.setText("tema4");
        }
    }
    public void back_to_menu_org(final ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("BSUIR HELPER");
        stage.setScene(scene);
        stage.show();
    }
}
