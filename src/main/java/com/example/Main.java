package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ElectricityUsageService service = new ElectricityUsageService();

        // 1. Add new usage records
        service.addUsage(150.75, "2024-10-12T10:00:00");
        System.out.println("Added Usage Record.");

        service.addUsage(200.50, "2024-10-13T11:30:00");
        System.out.println("Added Usage Record.");

        // 2. Retrieve and print all usage records
        List<ElectricityUsage> allUsages = service.getAllUsages();
        System.out.println("All Usage Records:");
        for (ElectricityUsage u : allUsages) {
            System.out.println("ID: " + u.getId() + ", Usage: " + u.getUsage() + " kWh, Timestamp: " + u.getTimestamp());
        }

        // 3. Update an existing record (assuming there is at least one record)
        if (!allUsages.isEmpty()) {
            String idToUpdate = allUsages.get(0).getId();
            service.updateUsage(idToUpdate, 180.25, "2024-10-12T12:00:00");
            System.out.println("Updated Usage Record with ID: " + idToUpdate);
        }

        // 4. Delete a usage record (again, assuming there's at least one)
        if (!allUsages.isEmpty()) {
            String idToDelete = allUsages.get(0).getId();
            service.deleteUsage(idToDelete);
            System.out.println("Deleted Usage Record with ID: " + idToDelete);
        }

        // 5. Retrieve and print all usage records again to confirm deletion
        allUsages = service.getAllUsages();
        System.out.println("All Usage Records after deletion:");
        for (ElectricityUsage u : allUsages) {
            System.out.println("ID: " + u.getId() + ", Usage: " + u.getUsage() + " kWh, Timestamp: " + u.getTimestamp());
        }
    }
}
