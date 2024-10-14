package com.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList; 
import java.util.List; 

public class ElectricityUsageDAO {
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public ElectricityUsageDAO() {
        this.database = MongoDBUtil.getDatabase();
        this.collection = database.getCollection("ElectricityUsage"); //-
    }

    // Create: Insert a new electricity usage record
    public void insertUsage(ElectricityUsage usage) {
        Document doc = new Document("usage", usage.getUsage())
                .append("timestamp", usage.getTimestamp());
        collection.insertOne(doc);
    }

    // Read: Retrieve all electricity usage records
    public List<ElectricityUsage> getAllUsages() {
        List<ElectricityUsage> usages = new ArrayList<>();
        for (Document doc : collection.find()) {
            ElectricityUsage usage = new ElectricityUsage();
            usage.setId(doc.getObjectId("_id").toString());
            usage.setUsage(doc.getDouble("usage"));
            usage.setTimestamp(doc.getString("timestamp"));
            usages.add(usage);
        }
        return usages;
    }

    // Update: Update an existing electricity usage record
    public void updateUsage(ElectricityUsage usage) {
        Document updatedDocument = new Document("usage", usage.getUsage())
                .append("timestamp", usage.getTimestamp());

        collection.updateOne(
                new Document("_id", new ObjectId(usage.getId())), // Filter by ID
                new Document("$set", updatedDocument) // Set the new values
        );
    }

    // Delete: Delete an electricity usage record
    public void deleteUsage(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id))); // Filter by ID
    }
}
