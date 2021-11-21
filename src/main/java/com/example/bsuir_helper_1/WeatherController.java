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

public class WeatherController {

    //TODO переименовать, проверить нужен ли тут public
    @FXML
    public Label donfound;

    @FXML
    private Text airPressure;

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
    private Text tempFills;

    @FXML
    private Text tempInfo;

    @FXML
    private Text windSpeed;

    @FXML
    private Text weather;

    private static final OpenMapWeatherService openMapWeatherService = new OpenMapWeatherService(new HttpService());

    @FXML
    //TODO тут и везде переименуйте переменные и методы в одном стиле, что-то вроже backToMenu, почитайте Java Code Convension
    void backtomenu(final ActionEvent event) throws IOException {
        final Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        final Scene scene = new Scene(root);
        stage.setTitle("BSUIR HELPER");
            stage.setScene(scene);
            stage.show();
        }

    @FXML
    public void initialize() {
        checkWeatherButton.setOnAction(event -> {
            final String getUserCity = cityenterfield.getText().trim();
            final Weather weatherForCity = openMapWeatherService.getWeatherForCity(getUserCity);
            if (weatherForCity.getPressure() == 0) {
                donfound.setTextFill(Color.RED);
                donfound.setText("THE CITY WASN'T FOUND");
            } else {
                donfound.setTextFill(Color.GREEN);
                donfound.setText("WEATHER IN THE " + getUserCity + " CITY");
                tempInfo.setText("TEMPERATURE: " + weatherForCity.getTemp() + " °C");
                tempFills.setText("FILLS LIKE: " + weatherForCity.getFeelsLike() + " °C");
                humidity.setText("HUMIDITY: " + weatherForCity.getHumidity() + "%");
                airPressure.setText("PRESSURE: " + weatherForCity.getPressure());
                windSpeed.setText("WIND SPEED: " + weatherForCity.getSpeed() + " М/C");
                this.weather.setText("WEATHER: " + weatherForCity.getDescription());
                cloudiness.setText("CLOUDINESS: " + weatherForCity.getCloudiness() + "%");
                country.setText("COUNTRY: " + weatherForCity.getCountry());
            }
        });
    }
}
