package com.example.bsuir_helper_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;
import java.io.IOException;
import java.util.Objects;



public class FlashCardsController {
    @FXML
    private Text eda;

    @FXML
    private Text ideas;




    public void generate_new_something(ActionEvent event) throws IOException {

        int rand = ThreadLocalRandom.current().nextInt(1, 4);
        switch (rand){
            case (1):
                eda.setText("tema1");
                break;
            case (2):
                eda.setText("tema2");
                break;
            case (3):
                eda.setText("tema3");
                break;
            case (4):
                eda.setText("tema4");
                break;

        }
    }
    public void generate_new_something2(ActionEvent event) throws IOException {

        int rand2 = ThreadLocalRandom.current().nextInt(1, 4);
        switch (rand2){
            case (1):
                ideas.setText("tema1");
                break;
            case (2):
                ideas.setText("tema2");
                break;
            case (3):
                ideas.setText("tema3");
                break;
            case (4):
                ideas.setText("tema4");
                break;

        }
    }
    public void back_to_menu_org(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("BSUIR HELPER");
        stage.setScene(scene);
        stage.show();

    }

}
