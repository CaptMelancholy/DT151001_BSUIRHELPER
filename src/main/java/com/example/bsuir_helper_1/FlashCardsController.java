package com.example.bsuir_helper_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
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

    public void GenerateNewPlace(){
        int NewRandFood = (int) (Math.random() *NumberOfFood);
        Food.setText(ListOfFood[NewRandFood]);

    }

    public void GenerateNewClasses(){
        int NewRandClasses = (int) (Math.random() *NumberOfClasses);
        Classes.setText(ListOfClasses[NewRandClasses]);
    }

    public void ChangeNameOfTab(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("change name");
        window.setMinWidth(400);

        TextField ChangeNameOfTab = new TextField("введите новое название");

        Button SaveButton = new Button("изменить название вкладки");
        SaveButton.setOnAction(e -> {
            if (!ChangeNameOfTab.getText().equals("введите новое название"))
            NameOfTopic.setText(ChangeNameOfTab.getText());
            window.close();

        });


        Button CloseButton = new Button("закрыть");
        CloseButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(ChangeNameOfTab, SaveButton, CloseButton);
        layout.setAlignment(Pos.CENTER);

        Scene SceneOfChangeTab = new Scene(layout);
        window.setScene(SceneOfChangeTab);
        window.show();
    }

    public void AddNewFlashCard(){

    }

    public void CheckListOfFlashCards(){

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
