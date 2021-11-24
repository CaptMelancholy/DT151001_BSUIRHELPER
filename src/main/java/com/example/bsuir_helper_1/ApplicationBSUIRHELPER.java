package com.example.bsuir_helper_1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationBSUIRHELPER extends javafx.application.Application {
    @Override
    public void start(final Stage stage) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(ApplicationBSUIRHELPER.class.getResource("sample.fxml"));
        final Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setResizable(false);
        stage.setTitle("BSUIR HELPER");
        stage.setScene(scene);
        stage.show();
        Notification.moveToCovid19AlertPage();
    }
    public static void main(final String[] args) {
        launch();
    }
}

