package com.example.bsuir_helper_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class ArticleController {
    @FXML
    public Button goToMainMenuButton;

    //TODO Придумать как это все сделать без повторения строк и строчек
    @FXML
    public void goToMenu(final ActionEvent event) throws IOException {
        final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

