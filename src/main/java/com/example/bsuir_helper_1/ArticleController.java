package com.example.bsuir_helper_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class ArticleController {
    @FXML
    public Button goonmainmenuButton;
    @FXML
    private Tab firstarticlesbutton;

    @FXML
    private ImageView imageButtonHome;

    @FXML
    private Tab secondarticlesbutton;

    @FXML
    private Button backButton;


    @FXML // Придумать как это все сделать без повторения строк и строчек
    public void gotomenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

