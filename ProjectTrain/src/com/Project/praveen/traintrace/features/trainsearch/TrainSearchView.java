package com.zsgs.praveen.traintrace.features.trainsearch;

import com.zsgs.praveen.traintrace.data.dto.Train;
import com.zsgs.praveen.traintrace.features.livestatus.LiveStatusView;
import com.zsgs.praveen.traintrace.util.AppScanner;
import java.util.List;
import java.util.Scanner;

public class TrainSearchView {
    private final TrainSearchModel trainSearchModel = new TrainSearchModel();
    private final LiveStatusView liveStatusView = new LiveStatusView();
    private final Scanner sc = AppScanner.get();

    public void locationSearch() {
        while (true) {
            System.out.println("\n====== Train Search ======");

            List<String> sources = trainSearchModel.getUniqueSources();
            System.out.println("Available Start Locations:");
            for (int i = 0; i < sources.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + sources.get(i));
            }
            System.out.print("Enter Start Location: ");
            String startLocation = sc.nextLine().trim();

            List<String> destinations = trainSearchModel.getDestinationsFrom(startLocation);
            if (destinations.isEmpty()) {
                System.out.println("No trains available from '" + startLocation + "'.");
                if (!askSearchAgain()) return;
                continue;
            }

            System.out.println("\nAvailable Destinations from " + startLocation + ":");
            for (int i = 0; i < destinations.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + destinations.get(i));
            }
            System.out.print("Enter End Location: ");
            String endLocation = sc.nextLine().trim();

            List<Train> result = trainSearchModel.findTrains(startLocation, endLocation);
            if (result.isEmpty()) {
                System.out.println("No trains found for this route.");
                if (!askSearchAgain()) return;
                continue;
            }

            System.out.println("\n===== Available Trains =====");
            for (int i = 0; i < result.size(); i++) {
                Train t = result.get(i);
                System.out.printf("  %d. %-10d %-30s [%s] %s%n",
                        (i + 1), t.getTrainNo(), t.getTrainName(), t.getType(), t.getDaysOfRunning());
            }

            boolean backToSearch = false;
            while (true) {
                System.out.println("\n1. Check Live Status & Full Schedule");
                System.out.println("2. Search Again");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");
                String choice = sc.nextLine().trim();

                switch (choice) {
                    case "1":
                        System.out.print("Select train (1 to " + result.size() + "): ");
                        try {
                            int selected = Integer.parseInt(sc.nextLine().trim());
                            if (selected < 1 || selected > result.size()) {
                                System.out.println("Invalid selection!"); break;
                            }
                            Train selectedTrain = result.get(selected - 1);
                            liveStatusView.showFullSchedule(selectedTrain.getTrainNo(), selectedTrain.getTrainName());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input!");
                        }
                        break;
                    case "2":
                        backToSearch = true; break;
                    case "3":
                        System.out.println("Thank you! Bye!"); return;
                    default:
                        System.out.println("Invalid choice!");
                }
                if (backToSearch) break;
            }
        }
    }

    private boolean askSearchAgain() {
        System.out.println("1. Search Again  2. Exit");
        System.out.print("Choose: ");
        if (sc.nextLine().trim().equals("1")) return true;
        System.out.println("Thank you! Bye!");
        return false;
    }
}