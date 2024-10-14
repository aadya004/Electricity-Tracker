package com.example;

import java.util.List;

public class ElectricityUsageService {
    private ElectricityUsageDAO dao;

    public ElectricityUsageService() {
        this.dao = new ElectricityUsageDAO();
    }

    // Method to add usage
    public void addUsage(double usage, String timestamp) {
        ElectricityUsage usageRecord = new ElectricityUsage();
        usageRecord.setUsage(usage);
        usageRecord.setTimestamp(timestamp);
        dao.insertUsage(usageRecord);
    }

    // Method to get all usages
    public List<ElectricityUsage> getAllUsages() {
        return dao.getAllUsages();
    }

    // Method to update usage
    public void updateUsage(String id, double usage, String timestamp) {
        ElectricityUsage usageRecord = new ElectricityUsage();
        usageRecord.setId(id);
        usageRecord.setUsage(usage);
        usageRecord.setTimestamp(timestamp);
        dao.updateUsage(usageRecord);
    }

    // Method to delete usage
    public void deleteUsage(String id) {
        dao.deleteUsage(id);
    }
}
