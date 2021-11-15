package com.example.bsuir_helper_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;
import java.io.IOException;
import java.util.Objects;

public class FlashCardsController {

    public void generate_new_something(ActionEvent event) throws IOException
    {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 10);
        //eda.setText("");
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
