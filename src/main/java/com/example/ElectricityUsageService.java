package com.example;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ElectricityUsageService {
    private ElectricityUsageDAO dao;

    public ElectricityUsageService() {
        this.dao = new ElectricityUsageDAO();
    }

    // Method to add usage
    public void addUsage(String day, double usage, String timestamp) {
        ElectricityUsage usageRecord = new ElectricityUsage();
        usageRecord.setUsage(usage);
        usageRecord.setDay(day);
        usageRecord.setTimestamp(timestamp);
        dao.insertUsage(usageRecord);
    }

    // Method to get all usages
    public List<ElectricityUsage> getAllUsages() {
        return dao.getAllUsages();
    }

    // Method to update usage
    public void updateUsage(String id, String day, double usage, String timestamp) {
        ElectricityUsage usageRecord = new ElectricityUsage();
        usageRecord.setId(id);
        usageRecord.setDay(day);
        usageRecord.setUsage(usage);
        usageRecord.setTimestamp(timestamp);
        dao.updateUsage(usageRecord);
    }

    // Method to delete usage
    public void deleteUsage(String id) {
        dao.deleteUsage(id);
    }

    // Method to provide usage data in a format compatible with Chart.js
    public Map<String, Object> getUsageChartData() {
        List<ElectricityUsage> usages = dao.getAllUsages();
        Map<String, Object> chartData = new HashMap<>();

        // Extracting days and usage values
        List<Double> usageValues = usages.stream().map(ElectricityUsage::getUsage).toList();
        List<String> days = usages.stream().map(ElectricityUsage::getDay).toList();
        // Prepare chart data
        chartData.put("labels", days); // x-axis labels (days)
        chartData.put("data", usageValues); // y-axis data (electricity usage)

        return chartData;

    }
}
