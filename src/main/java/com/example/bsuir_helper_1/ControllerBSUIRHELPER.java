package com.example.bsuir_helper_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
/**
 *Основной класс меню
 */
public class ControllerBSUIRHELPER {
    private Stage stage;
    private Scene scene;
    private Parent root;
    /**
     *Переход на окно змейки
     */
    public void moveToGameSnake(final ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gamesnake.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. PLAY IN FREE TIME");
        stage.centerOnScreen();
        stage.show();
    }
    /**
     *Переход на окно to-do списка
     */
    public void moveToOrganizer(final ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("organizer.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. TO-DO-LIST");
        stage.centerOnScreen();
        stage.show();
    }
    /**
     *Переход на окно флеш-карточек
     */
    public void moveToFlashcards(final ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("flashcards.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. FLASH-CARDS");
        stage.centerOnScreen();
        stage.show();
    }
    /**
     *Переход на окно прогноза погоды
     */
    public void moveToWeather(final ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("weather.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER. WEATHER CHECKER");
        stage.centerOnScreen();
        stage.show();
    }
}
