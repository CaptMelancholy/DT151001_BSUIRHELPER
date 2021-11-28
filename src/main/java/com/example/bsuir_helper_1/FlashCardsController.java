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
    private Text textOfNewFlashcard1;

    @FXML
    private Text textOfNewFlashcard2;

    @FXML
    private Text textOfNewFlashcard3;

    @FXML
    private Text textOfNewFlashcard4;

    @FXML
    private Text textOfNewFlashcard5;

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
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private Button nameOfTabButton;

    @FXML
    private Button addNewButton;

    @FXML
    private Button listOfFlashcardsButton;

    public final String [] listOfFood = new String[] {"CAFE (3RD BUILDING)", "CAFE (1TH BUILDING)","CAFE (2ND BUILDING)","CAFE (4TH BUILDING)","CAFE (5TH BUILDING)","CHURCH CONNECTED SHOP (5TH BUILDING)","SHOP 'FOOD/BAR' ","MACDONALD'S", "KFC", "BURGER KING","SHOP 'SOSEDI'", "VISIT COFIX", "VISIT HOTFIX", "VISIT LIDO","SHOP 'CORONA'"};
    public final int numberOfFood = Array.getLength(listOfFood);
    public final String [] listOfClasses = new String[] {"MAKE LABS","CHECK NEWS","DO YOUR STUDIES","WATCH NETFLIX","MEET WITH YOUR FRIENDS","TAKE A PHOTOWALK","PLAY GAMES","DO YOU HOBBY", "DO PROJECT ON JAVA"};
    public final int numberOfClasses = Array.getLength(listOfClasses);

    public final String [] listOfNewFlashcards = new String[15];
    public int numOfNewFlashcards = 0;
    public int numberOfScroll;
    public int nowNumberOfScroll = 0;

    public String nameOfTab;
    public String newFlashcard;

    public File fileNameOfTab = new File("fileNameOfTab.txt");
    public File newFlashcards = new File("newFlashcards.txt");

    @FXML
    private void initialize() {

        try(BufferedReader reader = new BufferedReader(new FileReader(fileNameOfTab))) {
            nameOfTab = reader.readLine();
            nameOfTopic.setText(nameOfTab);
        }catch (IOException e) {
            e.printStackTrace();
        }


        try(BufferedReader readerOfNewFlashcards = new BufferedReader(new FileReader(newFlashcards))){
            while((newFlashcard = readerOfNewFlashcards.readLine()) != null){
                if(!newFlashcard.equals("")){
                listOfNewFlashcards[numOfNewFlashcards] = newFlashcard;
                numOfNewFlashcards++;}
            }
            readerOfNewFlashcards.close();
            numberOfScroll = (numOfNewFlashcards-1)/5;
            if(numberOfScroll>0) nextButton.setDisable(false);
            textOfNewFlashcard1.setText(listOfNewFlashcards[nowNumberOfScroll*5]);
            textOfNewFlashcard2.setText(listOfNewFlashcards[nowNumberOfScroll*5+1]);
            textOfNewFlashcard3.setText(listOfNewFlashcards[nowNumberOfScroll*5+2]);
            textOfNewFlashcard4.setText(listOfNewFlashcards[nowNumberOfScroll*5+3]);
            textOfNewFlashcard5.setText(listOfNewFlashcards[nowNumberOfScroll*5+4]);
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
        try(BufferedReader reader = new BufferedReader(new FileReader(fileNameOfTab))){
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

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOfTab))){
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
            window.setTitle("WARNING!");
            window.setMinWidth(300);
            window.setMinHeight(100);

            Text WarningText = new Text("THE LIMIT OF FLASH-CARDS IS EXCEEDED");
            Button okWarningButton = new Button("OK");
            okWarningButton.setOnAction(e -> window.close());

            VBox layout = new VBox(2);
            layout.getChildren().addAll(WarningText,okWarningButton);
            layout.setAlignment(Pos.CENTER);

            Scene SceneOfChangeTab = new Scene(layout);
            window.setScene(SceneOfChangeTab);
            window.show();
        }
        else{
            newFlashcard = addNew.getText();
            if(!newFlashcard.equals("")){
            listOfNewFlashcards[numOfNewFlashcards] = newFlashcard;
            numOfNewFlashcards++;
            numberOfScroll = (numOfNewFlashcards-1)/5;
            if(numberOfScroll>0) nextButton.setDisable(false);

            switch ((numOfNewFlashcards-1)%5) {
                case (0) -> textOfNewFlashcard1.setText(newFlashcard);
                case (1) -> textOfNewFlashcard2.setText(newFlashcard);
                case (2) -> textOfNewFlashcard3.setText(newFlashcard);
                case (3) -> textOfNewFlashcard4.setText(newFlashcard);
                case (4) -> textOfNewFlashcard5.setText(newFlashcard);
                default -> textOfNewFlashcard1.setText("ERROR");
            }
            try(BufferedWriter writerOfNewFlashcards = new BufferedWriter(new FileWriter(newFlashcards,true))){
                writerOfNewFlashcards.write(newFlashcard+"\n");
                writerOfNewFlashcards.flush();
                writerOfNewFlashcards.close();
                addNew.setText("");
            }catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
    }

    public void delete(int number){
        if(numOfNewFlashcards!=0) {
            listOfNewFlashcards[number] = "";
            if (numOfNewFlashcards - 1 - number >= 0)
                System.arraycopy(listOfNewFlashcards, number + 1, listOfNewFlashcards, number, numOfNewFlashcards - 1 - number);
            listOfNewFlashcards[numOfNewFlashcards - 1] = "";
            numOfNewFlashcards--;
            try (BufferedWriter writerOfNewFlashcards = new BufferedWriter(new FileWriter(newFlashcards))){

                for (int i = 0; i < numOfNewFlashcards; i++) {
                    writerOfNewFlashcards.write(listOfNewFlashcards[i] + "\n");
                    writerOfNewFlashcards.flush();
                }
                writerOfNewFlashcards.close();
                numberOfScroll = (numOfNewFlashcards - 1) / 5;
                if (numberOfScroll <= nowNumberOfScroll) nextButton.setDisable(true);
                if (numOfNewFlashcards % 5 == 0 && nowNumberOfScroll != 0) {
                    nowNumberOfScroll--;
                }
                textOfNewFlashcard1.setText(listOfNewFlashcards[nowNumberOfScroll * 5]);
                textOfNewFlashcard2.setText(listOfNewFlashcards[nowNumberOfScroll * 5 + 1]);
                textOfNewFlashcard3.setText(listOfNewFlashcards[nowNumberOfScroll * 5 + 2]);
                textOfNewFlashcard4.setText(listOfNewFlashcards[nowNumberOfScroll * 5 + 3]);
                textOfNewFlashcard5.setText(listOfNewFlashcards[nowNumberOfScroll * 5 + 4]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void nameOfTabButton(){
        nameOfTabBackground.setVisible(true);
        addNewBackground.setVisible(false);
        listBackground.setVisible(false);
        nameOfTabButton.setDisable(true);
        addNewButton.setDisable(false);
        listOfFlashcardsButton.setDisable(false);
    }

    public void addNewButton(){
        nameOfTabBackground.setVisible(false);
        addNewBackground.setVisible(true);
        listBackground.setVisible(false);
        nameOfTabButton.setDisable(false);
        addNewButton.setDisable(true);
        listOfFlashcardsButton.setDisable(false);
    }

    public void listOfFlashcardsButton(){
        nameOfTabBackground.setVisible(false);
        addNewBackground.setVisible(false);
        listBackground.setVisible(true);
        nameOfTabButton.setDisable(false);
        addNewButton.setDisable(false);
        listOfFlashcardsButton.setDisable(true);
    }

    public void deleteButton1(){
        delete(nowNumberOfScroll*5);
    }

    public void deleteButton2(){
        delete(nowNumberOfScroll*5+1);
    }

    public void deleteButton3(){
        delete(nowNumberOfScroll*5+2);
    }

    public void deleteButton4(){
        delete(nowNumberOfScroll*5+3);
    }

    public void deleteButton5(){
        delete(nowNumberOfScroll*5+4);
    }

    public void backButton(){
        nowNumberOfScroll--;
        textOfNewFlashcard1.setText(listOfNewFlashcards[nowNumberOfScroll*5]);
        textOfNewFlashcard2.setText(listOfNewFlashcards[nowNumberOfScroll*5+1]);
        textOfNewFlashcard3.setText(listOfNewFlashcards[nowNumberOfScroll*5+2]);
        textOfNewFlashcard4.setText(listOfNewFlashcards[nowNumberOfScroll*5+3]);
        textOfNewFlashcard5.setText(listOfNewFlashcards[nowNumberOfScroll*5+4]);
        nextButton.setDisable(false);
        if(nowNumberOfScroll==0) backButton.setDisable(true);
        if(numberOfScroll<=nowNumberOfScroll) nextButton.setDisable(true);
    }

    public void nextButton(){
        nowNumberOfScroll++;
        textOfNewFlashcard1.setText(listOfNewFlashcards[nowNumberOfScroll*5]);
        textOfNewFlashcard2.setText(listOfNewFlashcards[nowNumberOfScroll*5+1]);
        textOfNewFlashcard3.setText(listOfNewFlashcards[nowNumberOfScroll*5+2]);
        textOfNewFlashcard4.setText(listOfNewFlashcards[nowNumberOfScroll*5+3]);
        textOfNewFlashcard5.setText(listOfNewFlashcards[nowNumberOfScroll*5+4]);
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
