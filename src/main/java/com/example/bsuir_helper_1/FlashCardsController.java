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

import java.io.*;
import java.lang.reflect.Array;
import java.util.Objects;

public class FlashCardsController {

    @FXML
    public Tab nameOfTopic;

    @FXML
    private Text food;

    @FXML
    private Text newCard;

    @FXML
    private Text newText1;

    @FXML
    private Text newText2;

    @FXML
    private Text newText3;

    @FXML
    private Text newText4;

    @FXML
    private Text newText5;

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

    @FXML
    private Button deleteButton1;

    @FXML
    private Button deleteButton2;

    @FXML
    private Button deleteButton3;

    @FXML
    private Button deleteButton4;

    @FXML
    private Button deleteButton5;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private Button nameOfTabButton;

    @FXML
    private Button addNewButton;

    @FXML
    private Button listOfFlashcardsButton;

    final public String [] listOfFood = new String[] {"сталовка 4к","сталовка 2к","буфет 4к","буфет 5к","церковная лавка","продукты бар","корона","буфут 2к"};
    final public int numberOfFood = Array.getLength(listOfFood);
    final public String [] listOfClasses = new String[] {"лабы/учеба","фильмец","накотить встречу с друзьями","прогуляться по улице","погамать в компик","заняться свои хобби"};
    final public int numberOfClasses = Array.getLength(listOfClasses);

    public String [] listOfNewFlashcards = new String[15];
    public int numOfNewFlashcards = 0;
    public int numberOfScroll;
    public int nowNumberOfScroll = 0;

    public String nameOfTab;
    public String newFlashcard;

    public File fileNameOfTab = new File("fileNameOfTab.txt");
    public File newFlashcards = new File("newFlashcards.txt");

    @FXML
    private void initialize() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileNameOfTab));
            nameOfTab = reader.readLine();
            nameOfTopic.setText(nameOfTab);
            reader.close();
            BufferedReader readerOfNewFlashcards = new BufferedReader(new FileReader(newFlashcards));
            while((newFlashcard = readerOfNewFlashcards.readLine()) != null){
                if(!newFlashcard.equals("")){
                listOfNewFlashcards[numOfNewFlashcards] = newFlashcard;
                numOfNewFlashcards++;}
            }
            numberOfScroll = (numOfNewFlashcards-1)/5;
            if(numberOfScroll>0) nextButton.setDisable(false);
            newText1.setText(listOfNewFlashcards[nowNumberOfScroll*5]);
            newText2.setText(listOfNewFlashcards[nowNumberOfScroll*5+1]);
            newText3.setText(listOfNewFlashcards[nowNumberOfScroll*5+2]);
            newText4.setText(listOfNewFlashcards[nowNumberOfScroll*5+3]);
            newText5.setText(listOfNewFlashcards[nowNumberOfScroll*5+4]);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateNewPlace(){
        int newRandFood = (int) (Math.random() *numberOfFood);
        food.setText(listOfFood[newRandFood]);

    }

    public void generateNewClasses(){
        int newRandClasses = (int) (Math.random() *numberOfClasses);
        classes.setText(listOfClasses[newRandClasses]);
    }

    public void generateNewFlashcard(){
        int newRandClasses = (int) (Math.random() *numOfNewFlashcards);
        if (numOfNewFlashcards != 0) newCard.setText(listOfNewFlashcards[newRandClasses]);
    }

    public void settings(){
    mainWindowBackground.setVisible(false);
    settingsWindowBackground.setVisible(true);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileNameOfTab));
            nameOfTab = reader.readLine();
            nameOfTopic.setText(nameOfTab);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void closeButton(){
        settingsWindowBackground.setVisible(false);
        mainWindowBackground.setVisible(true);
    }

    public void saveButton(){
        if (!Objects.equals(newNameOfTab.getText(), "")){
        nameOfTopic.setText(newNameOfTab.getText());
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOfTab));
                fileNameOfTab = null;
                writer.write(newNameOfTab.getText());
                writer.flush();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
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
            numberOfScroll = (numOfNewFlashcards-1)/5;
            if(numberOfScroll>0) nextButton.setDisable(false);
            switch ((numOfNewFlashcards-1)%5) {
                case (0) -> newText1.setText(addNew.getText());
                case (1) -> newText2.setText(addNew.getText());
                case (2) -> newText3.setText(addNew.getText());
                case (3) -> newText4.setText(addNew.getText());
                case (4) -> newText5.setText(addNew.getText());
                default -> System.out.println("error");
            }
            try{
                BufferedWriter writerOfNewFlashcards = new BufferedWriter(new FileWriter(newFlashcards,true));
                writerOfNewFlashcards.write(addNew.getText()+"\n");
                writerOfNewFlashcards.flush();
                writerOfNewFlashcards.close();
                addNew.setText("");
            }catch (IOException e) {
                e.printStackTrace();
            }
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

    public void deleteButton1(){

    }

    public void deleteButton2(){

    }

    public void deleteButton3(){

    }

    public void deleteButton4(){

    }

    public void deleteButton5(){

    }

    public void backButton(){
        nowNumberOfScroll--;
        newText1.setText(listOfNewFlashcards[nowNumberOfScroll*5]);
        newText2.setText(listOfNewFlashcards[nowNumberOfScroll*5+1]);
        newText3.setText(listOfNewFlashcards[nowNumberOfScroll*5+2]);
        newText4.setText(listOfNewFlashcards[nowNumberOfScroll*5+3]);
        newText5.setText(listOfNewFlashcards[nowNumberOfScroll*5+4]);
        nextButton.setDisable(false);
        if(nowNumberOfScroll==0) backButton.setDisable(true);
    }

    public void nextButton(){
        nowNumberOfScroll++;
        newText1.setText(listOfNewFlashcards[nowNumberOfScroll*5]);
        newText2.setText(listOfNewFlashcards[nowNumberOfScroll*5+1]);
        newText3.setText(listOfNewFlashcards[nowNumberOfScroll*5+2]);
        newText4.setText(listOfNewFlashcards[nowNumberOfScroll*5+3]);
        newText5.setText(listOfNewFlashcards[nowNumberOfScroll*5+4]);
        backButton.setDisable(false);
        if(nowNumberOfScroll==numberOfScroll) nextButton.setDisable(true);
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
