package com.example.bsuir_helper_1.weather;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;


public class OpenMapWeatherServiceTest {

    @Test
    public void testCityIsCorrectlyPassedToHttpService() {
        HttpService httpServiceMock = Mockito.mock(HttpService.class);
        Mockito.when(httpServiceMock.getUrlContent(Mockito.anyString())).thenReturn("{\"coord\":{\"lon\":27.5667,\"lat\":53.9},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":6.86,\"feels_like\":2.05,\"temp_min\":6.86,\"temp_max\":6.86,\"pressure\":1004,\"humidity\":66,\"sea_level\":1004,\"grnd_level\":978},\"visibility\":10000,\"wind\":{\"speed\":10.03,\"deg\":314,\"gust\":17.55},\"clouds\":{\"all\":82},\"dt\":1637403754,\"sys\":{\"type\":1,\"id\":8939,\"country\":\"BY\",\"sunrise\":1637387187,\"sunset\":1637417076},\"timezone\":10800,\"id\":625144,\"name\":\"Minsk\",\"cod\":200}\n}"); // todo put real sample of response instead of '{}'
        OpenMapWeatherService weatherService = new OpenMapWeatherService(httpServiceMock);
        String cityName = "Minsk";
        weatherService.getWeatherForCity(cityName);
        Mockito.verify(httpServiceMock).getUrlContent(Mockito.argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(Object o) {
                String passedUrl = (String)o;
                return passedUrl.contains(cityName);
            }
        }));
    }
}