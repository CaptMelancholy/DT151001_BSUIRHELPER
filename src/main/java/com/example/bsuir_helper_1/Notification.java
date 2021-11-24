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
    public static void moveToCovid19AlertPage(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("COVID-19 ALERT!");
        window.setMinWidth(250);
        window.setResizable(false);
        Label label = new Label();
        label.setText("Уважаемые пользователи приложения BSUIR HELPER.\n Команда разработчиков Dream Team считает своим долгом напомнить вам о необходимости носить маски в общественных местах,\n держать социальную дистанцию и пить витаминки, на фоне развивающихся новых штампов вируса. Мы знаем, насколько это тяжело, \n но мы уверены, что после всего этого мы войдем в дивный новый мир. Пожалуйста, сделайте прививку в ближайшем медицинском пункте, \n тщательно мойте руки, следите за своими друзьями и близкими и при первых симптомах обращайтесь к врачу. Берегите себя! \n");
        label.setTextAlignment(TextAlignment.CENTER);
        Button closeButton = new Button("Я прочитал и понял.");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene sceneOfAttention = new Scene(layout);
        window.setScene(sceneOfAttention);
        window.show();
    }
}
