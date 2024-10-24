package com.example.controller;

import com.example.ElectricityUsageService;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Controller implements HttpHandler {

    private ElectricityUsageService electricityUsageService;

    public Controller() {
        this.electricityUsageService = new ElectricityUsageService();  // Initialize service class
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "";

        // Handle GET requests
        if ("GET".equals(exchange.getRequestMethod())) {
            if (exchange.getRequestURI().getPath().equals("/getUsageData")) {
                // Call the service class to get usage data for Chart.js
                Map<String, Object> chartData = electricityUsageService.getUsageChartData();
                
                // Convert the chart data to JSON
                ObjectMapper objectMapper = new ObjectMapper();
                response = objectMapper.writeValueAsString(chartData);
            } else {
                response = "Endpoint not found!";
            }
        } else {
            // Handle other HTTP methods like POST, PUT, DELETE, etc.
            response = "Method Not Allowed!";
            exchange.sendResponseHeaders(405, -1);  // 405 Method Not Allowed
        }

        // Send response back to the client
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
