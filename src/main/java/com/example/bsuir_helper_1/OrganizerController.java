package com.example.bsuir_helper_1;


import java.io.*;
import java.time.LocalDate;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class OrganizerController {

    @FXML
    public Button addEventButton;

    @FXML
    public Text textOfOrg1;

    @FXML
    public Text textOfOrg2;

    @FXML
    public Text textOfOrg3;

    @FXML
    public Text textOfOrg4;

    @FXML
    public Text textOfOrg5;

    @FXML
    public Text textOfOrg6;

    @FXML
    public Text textOfOrg7;

    @FXML
    public Text textOfOrg8;

    @FXML
    public Text textOfOrg9;

    @FXML
    public Text textOfOrg10;

    @FXML
    public TextField eventDescriptionTextField;

    @FXML
    public DatePicker datePicker;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public Button nextButtonOrg;

    @FXML
    public Button backButtonOrg;

    public File organaiserList = new File("organaiserList.txt");
    String newTask;
    String[] listOfTasks = new String[40];
    String[] listOfColors = new String[40];
    int numberOfTasks = 0;
    int numberOfScroll;
    int nowNumberOfScroll;
    @FXML
    public void initialize() {
        if(numberOfScroll<=nowNumberOfScroll) nextButtonOrg.setDisable(true);
        if(nowNumberOfScroll == 0) backButtonOrg.setDisable(true);
        choiceBox.getItems().addAll("Light", "Medium", "High");
        choiceBox.setValue("Light");
        try(BufferedReader readerOfNewFlashcards = new BufferedReader(new FileReader(organaiserList))){
            while((newTask = readerOfNewFlashcards.readLine()) != null){
                    listOfTasks[numberOfTasks] = newTask;
                    listOfColors[numberOfTasks] = readerOfNewFlashcards.readLine();
                    numberOfTasks++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        numberOfScroll = (numberOfTasks-1)/10;
        if(numberOfScroll>0) nextButtonOrg.setDisable(false);
        changeTasks();
    }

    public void changeTasks(){
        textOfOrg1.setText(listOfTasks[nowNumberOfScroll * 10]);
            if(!Objects.equals(listOfColors[nowNumberOfScroll * 10], null)) switch (listOfColors[nowNumberOfScroll*10]){
            case("Light") -> textOfOrg1.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg1.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg1.setStyle("-fx-fill: red;");
            default -> textOfOrg1.setStyle("-fx-fill: purple;");
        }
        textOfOrg2.setText(listOfTasks[nowNumberOfScroll * 10+1]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+1], null)) switch (listOfColors[nowNumberOfScroll*10+1]){
            case("Light") -> textOfOrg2.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg2.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg2.setStyle("-fx-fill: red;");
            default -> textOfOrg2.setStyle("-fx-fill: purple;");
        }
        textOfOrg3.setText(listOfTasks[nowNumberOfScroll * 10+2]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+2], null)) switch (listOfColors[nowNumberOfScroll*10+2]){
            case("Light") -> textOfOrg3.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg3.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg3.setStyle("-fx-fill: red;");
            default -> textOfOrg3.setStyle("-fx-fill: purple;");
        }
        textOfOrg4.setText(listOfTasks[nowNumberOfScroll * 10+3]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+3], null)) switch (listOfColors[nowNumberOfScroll*10+3]){
            case("Light") -> textOfOrg4.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg4.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg4.setStyle("-fx-fill: red;");
            default -> textOfOrg4.setStyle("-fx-fill: purple;");
        }
        textOfOrg5.setText(listOfTasks[nowNumberOfScroll * 10+4]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+4], null)) switch (listOfColors[nowNumberOfScroll*10+4]){
            case("Light") -> textOfOrg5.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg5.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg5.setStyle("-fx-fill: red;");
            default -> textOfOrg5.setStyle("-fx-fill: purple;");
        }
        textOfOrg6.setText(listOfTasks[nowNumberOfScroll * 10+5]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+5], null)) switch (listOfColors[nowNumberOfScroll*10+5]){
            case("Light") -> textOfOrg6.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg6.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg6.setStyle("-fx-fill: red;");
            default -> textOfOrg6.setStyle("-fx-fill: purple;");
        }
        textOfOrg7.setText(listOfTasks[nowNumberOfScroll * 10+6]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+6],null)) switch (listOfColors[nowNumberOfScroll*10+6]){
            case("Light") -> textOfOrg7.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg7.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg7.setStyle("-fx-fill: red;");
            default -> textOfOrg7.setStyle("-fx-fill: purple;");
        }
        textOfOrg8.setText(listOfTasks[nowNumberOfScroll * 10+7]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+7], null)) switch (listOfColors[nowNumberOfScroll*10+7]){
            case("Light") -> textOfOrg8.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg8.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg8.setStyle("-fx-fill: red;");
            default -> textOfOrg8.setStyle("-fx-fill: purple;");
        }
        textOfOrg9.setText(listOfTasks[nowNumberOfScroll * 10+8]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+8], null)) switch (listOfColors[nowNumberOfScroll*10+8]){
            case("Light") -> textOfOrg9.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg9.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg9.setStyle("-fx-fill: red;");
            default -> textOfOrg9.setStyle("-fx-fill: purple;");
        }
        textOfOrg10.setText(listOfTasks[nowNumberOfScroll * 10+9]);
        if(!Objects.equals(listOfColors[nowNumberOfScroll * 10+9], null)) switch (listOfColors[nowNumberOfScroll*10+9]){
            case("Light") -> textOfOrg10.setStyle("-fx-fill: green;");
            case("Medium") -> textOfOrg10.setStyle("-fx-fill: yellow;");
            case("High") -> textOfOrg10.setStyle("-fx-fill: red;");
            default -> textOfOrg10.setStyle("-fx-fill: purple;");
        }
    }
    public void changePrioritize(int number) {
    }
    public void changePrioritize1(){

    }

    public void changePrioritize2(){

    }
    public void changePrioritize3(){

    }
    public void changePrioritize4(){

    }
    public void changePrioritize5(){

    }
    public void changePrioritize6(){

    }
    public void changePrioritize7(){

    }
    public void changePrioritize8(){

    }
    public void changePrioritize9(){

    }
    public void changePrioritize10(){

    }
    public void delete(int number){
        if(numberOfTasks!=0) {
            listOfTasks[number] = "";
            listOfColors[number] = "";
            if (numberOfTasks - 1 - number >= 0) {
                System.arraycopy(listOfTasks, number + 1, listOfTasks, number, numberOfTasks - 1 - number);
                System.arraycopy(listOfColors, number + 1, listOfColors, number, numberOfTasks - 1 - number);
            }listOfTasks[numberOfTasks - 1] = "";
            listOfColors[numberOfTasks - 1] = "";
            numberOfTasks--;
            try (BufferedWriter writerOfNewFlashcards = new BufferedWriter(new FileWriter(organaiserList))){

                for (int i = 0; i < numberOfTasks; i++) {
                    writerOfNewFlashcards.write(listOfTasks[i] + "\n");
                    writerOfNewFlashcards.write(listOfColors[i] +"\n");
                    writerOfNewFlashcards.flush();
                }
                writerOfNewFlashcards.close();
                numberOfScroll = (numberOfTasks - 1) / 10;
                if (numberOfScroll <= nowNumberOfScroll) nextButtonOrg.setDisable(true);
                if (numberOfTasks % 10 == 0 && nowNumberOfScroll != 0) {
                    nowNumberOfScroll--;
                }
                changeTasks();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void addEventHandler() {
        if (numberOfTasks > 39) {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Warning!");
            window.setMinWidth(300);
            window.setMinHeight(100);

            Text WarningText = new Text("The limit of tasks is exceeded");
            Button okWarningButton = new Button("ok");
            okWarningButton.setOnAction(e -> window.close());

            VBox layout = new VBox(2);
            layout.getChildren().addAll(WarningText,okWarningButton);
            layout.setAlignment(Pos.CENTER);

            Scene SceneOfChangeTab = new Scene(layout);
            window.setScene(SceneOfChangeTab);
            window.show();
        } else {
            if(!Objects.equals(eventDescriptionTextField.getText(), "")){
                if(datePicker.getValue() == null) datePicker.setValue(LocalDate.now());
                newTask = datePicker.getValue() + " " + eventDescriptionTextField.getText();
            eventDescriptionTextField.setText("");
            listOfTasks[numberOfTasks] = newTask;
            listOfColors[numberOfTasks] = choiceBox.getValue();
            numberOfScroll = numberOfTasks/10;
                if(numberOfScroll>0) nextButtonOrg.setDisable(false);
            switch (numberOfTasks % 10) {
                    case (0) -> textOfOrg1.setText(newTask);
                    case (1) -> textOfOrg2.setText(newTask);
                    case (2) -> textOfOrg3.setText(newTask);
                    case (3) -> textOfOrg4.setText(newTask);
                    case (4) -> textOfOrg5.setText(newTask);
                    case (5) -> textOfOrg6.setText(newTask);
                    case (6) -> textOfOrg7.setText(newTask);
                    case (7) -> textOfOrg8.setText(newTask);
                    case (8) -> textOfOrg9.setText(newTask);
                    case (9) -> textOfOrg10.setText(newTask);
                    default -> textOfOrg1.setText("error");
                }
                numberOfTasks++;
                try(BufferedWriter writerOfNewFlashcards = new BufferedWriter(new FileWriter(organaiserList,true))){
                    writerOfNewFlashcards.write(newTask+"\n");
                    writerOfNewFlashcards.write(choiceBox.getValue()+"\n");
                    writerOfNewFlashcards.flush();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void deleteButtonOrg1(){
        delete(nowNumberOfScroll*10);
    }

    public void deleteButtonOrg2(){
        delete(nowNumberOfScroll*10+1);
    }

    public void deleteButtonOrg3(){
        delete(nowNumberOfScroll*10+2);
    }

    public void deleteButtonOrg4(){
        delete(nowNumberOfScroll*10+3);
    }

    public void deleteButtonOrg5(){
        delete(nowNumberOfScroll*10+4);
    }

    public void deleteButtonOrg6(){
        delete(nowNumberOfScroll*10+5);
    }

    public void deleteButtonOrg7(){
        delete(nowNumberOfScroll*10+6);
    }

    public void deleteButtonOrg8(){
        delete(nowNumberOfScroll*10+7);
    }

    public void deleteButtonOrg9(){
        delete(nowNumberOfScroll*10+8);
    }

    public void deleteButtonOrg10(){
        delete(nowNumberOfScroll*10+9);
    }

    public void nextButtonOrg(){
        nowNumberOfScroll++;
        changeTasks();
        backButtonOrg.setDisable(false);
        if(nowNumberOfScroll==numberOfScroll) nextButtonOrg.setDisable(true);
    }

    public void backButtonOrg(){
        nowNumberOfScroll--;
        changeTasks();
        nextButtonOrg.setDisable(false);
        if(nowNumberOfScroll==0) backButtonOrg.setDisable(true);
        if(numberOfScroll==nowNumberOfScroll) nextButtonOrg.setDisable(true);
    }

    public void gotoMainMenu(final ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER");
        stage.centerOnScreen();
        stage.show();
    }
}