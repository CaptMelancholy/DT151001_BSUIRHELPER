package com.example.bsuir_helper_1.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpService {
    public String getUrlContent(final String urlAddress) {
        final StringBuilder content = new StringBuilder();
        try {
            final URL url = new URL(urlAddress);
            final URLConnection urlConn = url.openConnection();

            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception ignored) {
        }
        return content.toString();
    }
}
