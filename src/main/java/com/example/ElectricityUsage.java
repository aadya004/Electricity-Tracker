package com.example;

public class ElectricityUsage {
    private String id;
    private double usage;
    private String day;
    private String timestamp;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day=day;
    }
    public double getUsage() {
        return usage;
    }

    public void setUsage(double usage) {
        this.usage = usage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
