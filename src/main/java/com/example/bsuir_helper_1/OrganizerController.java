package com.example.bsuir_helper_1;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class OrganizerController implements Initializable {

    @FXML
    private Button addEventButton;

    @FXML
    private TextField eventDescriptionTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ListView<LocalEvent> eventListView;


    @FXML
    private void addEventHandler(ActionEvent e)
    {
        //создает новое событие
        var newEvent = new LocalEvent(datePicker.getValue(), eventDescriptionTextField.getText());

        //добавляет событие
        eventListView.getItems().add(newEvent);

        //сегодняшняя дата
        datePicker.setValue(LocalDate.now());

        eventDescriptionTextField.setText("");
    }

    public Object[] getEvents()  {
        return eventListView.getItems().toArray();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            var events = EventSerializer.deserialize();
            eventListView.getItems().addAll(events);
        }catch(Exception e)  {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("TodoFX");
            alert.setHeaderText("Events could not be loaded from file system");
        }

    }

    public void gotoMainMenu(final ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER");
        stage.centerOnScreen();
        stage.show();
    }
}
