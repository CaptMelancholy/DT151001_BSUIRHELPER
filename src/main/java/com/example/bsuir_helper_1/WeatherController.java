package com.example.bsuir_helper_1;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

import javafx.stage.Stage;
import org.json.JSONObject;

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
    void initialize() {
        checkWeatherButton.setOnAction(event -> {
            String getUserCity = cityenterfield.getText().trim();
            String output = getUrlContent("https://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=e69fcdd9b060345b438437356f59cb01&units=metric&lang=en");
            System.out.println(output);
            if(!output.isEmpty()) {
                donfound.setTextFill(Color.GREEN);
                donfound.setText("CITY " + getUserCity + " WEATHER");
                JSONObject obj = new JSONObject(output);
                temp_info.setText("TEMPERATURE: " + obj.getJSONObject("main").getDouble("temp") + " °C");
                temp_fills.setText("FILLS LIKE: " + obj.getJSONObject("main").getDouble("feels_like") + " °C");
                humidity.setText("humidity: " + obj.getJSONObject("main").getDouble("humidity") + "%");
                air_pressure.setText("AIR PRESSURE: " + obj.getJSONObject("main").getDouble("pressure"));
                wind_speed.setText("WIND SPEED: " + obj.getJSONObject("wind").getDouble("speed") + " М/C");
                weather.setText("Weather: " + obj.getJSONArray("weather").getJSONObject(Integer.parseInt("0")).getString("description"));
                cloudiness.setText("Cloudiness: " + obj.getJSONObject("clouds").getDouble("all") + "%");
                country.setText("COUNTRY: " + obj.getJSONObject("sys").getString("country"));
            }
        });
    }

    /**
     * @param urlAdress // TODO information about class
     * @return content.toString()
     */
    private String getUrlContent(String urlAdress) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();

        } catch (Exception e) {
            donfound.setTextFill(Color.RED);
            donfound.setText("CITY DOESN'T FOUND");
            System.out.println("!!!");

        }
        return content.toString();
    }

}
