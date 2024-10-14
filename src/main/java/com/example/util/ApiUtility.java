package com.example.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class ApiUtility {

    private static HttpClient client = HttpClient.newHttpClient();

    // Method to fetch data from an external API using modern HttpClient
    public static String fetchUsageData(String urlString) throws IOException, InterruptedException {
        // Create a GET request object
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body if successful, otherwise throw an exception
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new IOException("Unexpected response code: " + response.statusCode());
        }
    }
}
