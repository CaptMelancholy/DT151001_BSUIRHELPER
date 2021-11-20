package com.example.bsuir_helper_1.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpService {

    public String getUrlContent(String urlAddress) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(urlAddress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();

        } catch (Exception ignored) {


        }
        return content.toString();
    }
}
