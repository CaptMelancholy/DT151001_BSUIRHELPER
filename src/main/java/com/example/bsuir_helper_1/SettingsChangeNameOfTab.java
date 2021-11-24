package com.example.bsuir_helper_1;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsChangeNameOfTab {
    @FXML
    public static Tab NameOfTopic;

    public static void setNameOfTab() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("change name");
        window.setMinWidth(400);

        TextField ChangeNameOfTab = new TextField("введите новое название");

        Button SaveButton = new Button("изменить название вкладки");
        SaveButton.setOnAction(e -> {
            if (!ChangeNameOfTab.getText().equals("введите новое название"))
                NameOfTopic.setText(ChangeNameOfTab.getText());
            window.close();

        });


        Button CloseButton = new Button("закрыть");
        CloseButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(ChangeNameOfTab, SaveButton, CloseButton);
        layout.setAlignment(Pos.CENTER);

        Scene SceneOfChangeTab = new Scene(layout);
        window.setScene(SceneOfChangeTab);
        window.show();
    }
}
