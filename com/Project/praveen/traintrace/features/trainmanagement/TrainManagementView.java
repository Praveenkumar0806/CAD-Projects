package com.Project.praveen.traintrace.features.trainmanagement;

import com.Project.praveen.traintrace.data.dto.Train;
import com.Project.praveen.traintrace.util.AppScanner;
import java.util.Scanner;

public class TrainManagementView {
    private final TrainManagementModel trainManagementModel = new TrainManagementModel();
    private final Scanner sc = AppScanner.get();

    public void display() {
        while (true) {
            System.out.println("\n===== Admin Management =====");
            System.out.println("1. Add New Train");
            System.out.println("2. Remove Train");
            System.out.println("3. View All Trains");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();
            switch (input) {
                case "1": addNewTrain(); break;
                case "2": deleteTrain(); break;
                case "3": viewTrains(); break;
                case "4": return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void addNewTrain() {
        System.out.println("\n----- Add New Train -----");
        System.out.print("Train Number   : ");
        int trainNo;
        try {
            trainNo = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid train number!"); return;
        }
        System.out.print("Train Name     : ");
        String name = sc.nextLine().trim();
        System.out.print("Source         : ");
        String source = sc.nextLine().trim();
        System.out.print("Destination    : ");
        String dest = sc.nextLine().trim();
        System.out.print("Type (Express/Superfast/VandeBharat): ");
        String type = sc.nextLine().trim();
        System.out.print("Days of Running (Daily / Mon,Wed,Fri): ");
        String days = sc.nextLine().trim();

        if (trainManagementModel.addTrain(new Train(trainNo, name, source, dest, type, days))) {
            System.out.println("Train '" + name + "' added successfully!");
        } else {
            System.out.println("Error: Train number " + trainNo + " already exists!");
        }
    }

    private void deleteTrain() {
        System.out.println("\n----- Remove Train -----");
        System.out.print("Enter Train Number to remove: ");
        try {
            int no = Integer.parseInt(sc.nextLine().trim());
            if (trainManagementModel.removeTrain(no)) {
                System.out.println("Train removed successfully!");
            } else {
                System.out.println("Train not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid train number!");
        }
    }

    private void viewTrains() {
        System.out.println("\n===== All Trains =====");
        System.out.printf("%-10s %-30s %-20s %-20s %-15s %s%n",
                "No.", "Name", "Source", "Destination", "Type", "Days");
        System.out.println("-".repeat(105));
        for (Train t : trainManagementModel.getAllTrains()) {
            System.out.printf("%-10d %-30s %-20s %-20s %-15s %s%n",
                    t.getTrainNo(), t.getTrainName(),
                    t.getTrainSource(), t.getTrainDestination(),
                    t.getType(), t.getDaysOfRunning());
        }
    }
}