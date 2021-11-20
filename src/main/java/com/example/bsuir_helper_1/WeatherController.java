package com.example.bsuir_helper_1;

import com.example.bsuir_helper_1.weather.HttpService;
import com.example.bsuir_helper_1.weather.OpenMapWeatherService;
import com.example.bsuir_helper_1.weather.Weather;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Objects;

import javafx.stage.Stage;

/**
 * WeatherController class for managing the Weather Checker window and implementation of its functionality
 * @author CaptMelancholy (Danko Artyom)
 * @version 1.0
 */

public class WeatherController {

    @FXML
    public Label donfound;
    @FXML
    private Text air_pressure;
    @FXML
    private Button checkWeatherButton;

    @FXML
    private TextField cityenterfield;

    @FXML
    private Text cloudiness;

    @FXML
    private Text country;

    @FXML
    private Text humidity;

    @FXML
    private Text temp_fills;

    @FXML
    private Text temp_info;

    @FXML
    private Text wind_speed;

    @FXML
    private Text weather;

    public OpenMapWeatherService openMapWeatherService = new OpenMapWeatherService(new HttpService());

    /**
     * A method that initializes the return to the main page by clicking the button.
     * @param event it is an object describing the user clicks on the button
     * @throws IOException when there is error connected with an input or an output
     */
    @FXML
    void backtomenu(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("BSUIR HELPER");
            stage.setScene(scene);
            stage.show();
        }

    /**
     * The method responsible for receiving information from the text input field, transferring it to a link, receiving information from the server of the weather forecast site and transferring data from it to separate text fields
     */
    @FXML
    public void initialize() {
        checkWeatherButton.setOnAction(event -> {
            String getUserCity = cityenterfield.getText().trim();
            Weather weather = openMapWeatherService.getWeatherForCity(getUserCity);
            if (weather.getPressure() == 0) {
                donfound.setTextFill(Color.RED);
                donfound.setText("THE CITY WASN'T FOUND");
            } else {
                donfound.setTextFill(Color.GREEN);
                donfound.setText("WEATHER IN THE " + getUserCity + " CITY");
                temp_info.setText("TEMPERATURE: " + weather.getTemp() + " °C");
                temp_fills.setText("FILLS LIKE: " + weather.getFeels_like() + " °C");
                humidity.setText("HUMIDITY: " + weather.getHumidity() + "%");
                air_pressure.setText("PRESSURE: " + weather.getPressure());
                wind_speed.setText("WIND SPEED: " + weather.getSpeed() + " М/C");
                this.weather.setText("WEATHER: " + weather.getDescription());
                cloudiness.setText("CLOUDINESS: " + weather.getCloudiness() + "%");
                country.setText("COUNTRY: " + weather.getCountry());
            }
        });
    }



}
