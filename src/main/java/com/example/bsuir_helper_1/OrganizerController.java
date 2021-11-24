package com.example.bsuir_helper_1;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


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
        //create new Event by getting values from gui
        var newEvent = new LocalEvent(datePicker.getValue(), eventDescriptionTextField.getText());

        // add the new event to the list
        eventListView.getItems().add(newEvent);

        //reset fields
        // set date on today
        datePicker.setValue(LocalDate.now());

        // set text empty
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

}
