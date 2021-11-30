package com.example.bsuir_helper_1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Notification {
    /**
     * Covid-19 notification
     */
    public static void moveToCovid19AlertPage(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("COVID-19 ALERT!");
        window.setMinWidth(250);
        window.setResizable(false);
        Label label = new Label();
        label.setText("Уважаемые пользователи приложения BSUIR HELPER.\n \n Команда разработчиков Dream Team считает своим долгом \n напомнить вам о необходимости носить маски в общественных местах,\n держать социальную дистанцию и пить витаминки. Мы знаем, насколько это тяжело, \n но мы просим вас не опускать руки и готовиться к завершению LockDown-а. \n Пожалуйста, сделайте прививку в ближайшем медицинском пункте, \n тщательно мойте руки, следите за своими друзьями и близкими \n и при первых симптомах обращайтесь к врачу. Берегите себя! \n \n");
        label.setTextAlignment(TextAlignment.CENTER);
        Button closeButton = new Button("AGREE");
        closeButton.setStyle("-fx-background-color:  #7867b6; -fx-background-radius: 30; -fx-font-size: 18");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setStyle("-fx-font-family: Comfortaa; -fx-background-color: #a297cd");
        layout.setAlignment(Pos.CENTER);

        Scene sceneOfAttention = new Scene(layout);
        window.setScene(sceneOfAttention);
        window.show();
    }
}
