package com.example.controller;

import com.example.util.ApiUtility;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.io.IOException;

public class Controller implements HttpHandler {
    
    // Handle HTTP GET requests to the /getUsageData endpoint
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String response;
            try {
                // Call the utility class to fetch data from an external API
                response = ApiUtility.fetchUsageData("https://api.example.com/usage");
            } catch (Exception e) {
                e.printStackTrace();
                response = "Error occurred while fetching data";
            }

            // Send the response back to the client
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            // If not a GET request, return method not allowed
            exchange.sendResponseHeaders(405, -1);  // 405 Method Not Allowed
        }
    }
}
