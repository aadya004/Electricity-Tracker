package com.example;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
    private static MongoClient mongoClient; // Keep MongoClient instance
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
            mongoClient = new MongoClient(uri);
            database = mongoClient.getDatabase("ElectricityTrackerDB");
        }
        return database;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close(); // Close MongoClient
            mongoClient = null; // Set to null to indicate it's closed
        }
    }
}
