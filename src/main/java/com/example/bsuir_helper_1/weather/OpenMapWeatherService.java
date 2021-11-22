package com.example.bsuir_helper_1.weather;

import org.json.JSONObject;

public class OpenMapWeatherService {
    public static final String OPENWEATHERMAP_SERVICE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final HttpService httpService;

    public OpenMapWeatherService(final HttpService service) {
        this.httpService = service;
    }

    public Weather getWeatherForCity(final String city) {
        return getResponseFromService(city);
    }

    public Weather getResponseFromService(final String getUserCity) {
        final String output = httpService.getUrlContent(OPENWEATHERMAP_SERVICE_URL + "?q=" + getUserCity + "&appid=e69fcdd9b060345b438437356f59cb01&units=metric&lang=en");
        final Weather weather = new Weather();
        if (!output.isEmpty()) {
            JSONObject obj = new JSONObject(output);
            weather.setTemp(obj.getJSONObject("main").getDouble("temp"));
            weather.setFeelsLike(obj.getJSONObject("main").getDouble("feels_like"));
            weather.setHumidity(obj.getJSONObject("main").getDouble("humidity"));
            weather.setPressure(obj.getJSONObject("main").getDouble("pressure"));
            weather.setSpeed(obj.getJSONObject("wind").getDouble("speed"));
            weather.setDescription(obj.getJSONArray("weather").getJSONObject(Integer.parseInt("0")).getString("description"));
            weather.setCloudiness(obj.getJSONObject("clouds").getDouble("all"));
            weather.setCountry(obj.getJSONObject("sys").getString("country"));
        }
        return weather;
    }
}
