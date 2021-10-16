package com.example.bsuir_helper_1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button menuArticlesButton;

    @FXML
    private Button menuFlashCardsButton;

    @FXML
    private Button menuGameButton;

    @FXML
    private Button menuOrganizerButton;

    @FXML
    void initialize () {
        menuArticlesButton.setOnAction(actionEvent -> {
            menuArticlesButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("article.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                );
    }
}
