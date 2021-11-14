package com.example.bsuir_helper_1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private DialogPane covid19dialog;

    public void movetogamesnake(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gamesnake.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. JUST-TO-CHILL");
        stage.show();
 }

    public void movetoarticles(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("article.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. ARTICLES");
        stage.show();
    }

    public void movetoorganizer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("organizer.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. ORGANIZER");
        stage.show();
    }

    public void movetoflashcards(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("flashcards.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. FLASH-CARDS");
        stage.show();
    }


    public void movetoweather(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("weather.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. WEATHER CHECKER");
        stage.show();
    }

    public void covid19(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("COVID-19 ALERT!");
        window.setMinWidth(250);
        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        label.setText("Уважаемые пользователи приложения BSUIR HELPER.");

        label1.setText("Команда разработчиков Dream Team считает своим долгом напомнить вам о необходимости носить маски в общественных местах,");
        label2.setText("держать социальную дистанцию и пить витаминки, на фоне развивающихся новых штампов вируса. Мы знаем, насколько это тяжело,");
        label3.setText("но мы уверены, что после всего этого мы войдем в дивный новый мир. Пожалуйста, сделайте прививку в ближайшем медицинском пункте,");
        label4.setText("тщательно мойте руки, следите за своими друзьями и близкими и при первых симптомах обращайтесь к врачу. Берегите себя!");
        label5.setText("");
        Button closeButton = new Button("Я прочитал и понял.");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, label1, label2, label3, label4, label5, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }
}
