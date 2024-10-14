package com.example;

import com.example.controller.Controller;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server that listens on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        System.out.println("Server started on port 8000");

        // Bind endpoint `/getUsageData` to the controller method
        server.createContext("/getUsageData", new Controller());
        server.setExecutor(null);  // Use the default executor
        server.start();
    }
}
