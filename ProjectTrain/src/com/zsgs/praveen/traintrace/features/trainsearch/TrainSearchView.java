package com.zsgs.praveen.traintrace.features.trainsearch;
import com.zsgs.praveen.traintrace.data.dto.Train;
import com.zsgs.praveen.traintrace.features.livestatus.LiveStatusModel;
import com.zsgs.praveen.traintrace.features.trainmanagement.TrainManagementModel;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TrainSearchView {
    private TrainSearchModel model;
    private Scanner sc = new Scanner(System.in);

    public TrainSearchView() {
        this.model = new TrainSearchModel();
    }

    public void locationSearch() {
        while (true) {
            System.out.println("------Train Search------");


            List<String> startLocations = getUniqueStartLocations();
            System.out.println("Available Start Locations:");
            for (int i = 0; i < startLocations.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + startLocations.get(i));
            }
            System.out.println("------------------------");
            System.out.print("Enter Start Location: ");
            String startLocation = sc.nextLine();


            List<String> endLocations = getEndLocationsFor(startLocation);
            if (endLocations.isEmpty()) {
                System.out.println("No trains available from " + startLocation);
                System.out.println("\n1. Search Again");
                System.out.println("2. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) continue;
                else {
                    System.out.println("Thank you! Bye!");
                    return;
                }
            }

            System.out.println("\nAvailable End Locations from " + startLocation + ":");
            for (int i = 0; i < endLocations.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + endLocations.get(i));
            }
            System.out.println("------------------------");
            System.out.print("Enter End Location: ");
            String endLocation = sc.nextLine();

            List<Train> result = model.findTrains(startLocation, endLocation);

            if (result.isEmpty()) {
                System.out.println("Sorry!...No Trains Available This Route..");
                System.out.println("\n1. Search Again");
                System.out.println("2. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) continue;
                else {
                    System.out.println("Thank you! Bye!");
                    return;
                }
            }

            System.out.println("-----Available Trains-----");
            for (int i = 0; i < result.size(); i++) {
                Train t = result.get(i);
                System.out.println((i + 1) + ". " + t.getTrainNo() + "  " + t.getTrainName());
            }

            while (true) {
                System.out.println("\n1. Check Live Status");
                System.out.println("2. Search Again");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Select Train Number (1 to " + result.size() + "): ");
                        int selected = sc.nextInt();
                        sc.nextLine();

                        if (selected < 1 || selected > result.size()) {
                            System.out.println("Invalid selection! Try again.");
                            break;
                        }

                        Train selectedTrain = result.get(selected - 1);
                        LiveStatusModel statusModel = new LiveStatusModel();


                        System.out.println("---------------------------------");
                        System.out.println("TRAIN NO   : " + selectedTrain.getTrainNo());
                        System.out.println("TRAIN NAME : " + selectedTrain.getTrainName());
                        System.out.println(statusModel.getFullSchedule(selectedTrain.getTrainNo()));
                        System.out.println("---------------------------------");
                        break;

                    case 2:
                        break;
                    case 3:
                        System.out.println("Thank you! Bye!");
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
                if (choice == 2) break;
            }
        }
    }


    private List<String> getUniqueStartLocations() {
        List<String> locations = new ArrayList<>();
        TrainManagementModel mgmt = new TrainManagementModel();
        for (Train t : mgmt.getAllTrains()) {
            if (!locations.contains(t.getTrainSource())) {
                locations.add(t.getTrainSource());
            }
        }
        return locations;
    }


    private List<String> getEndLocationsFor(String startLocation) {
        List<String> locations = new ArrayList<>();
        TrainManagementModel mgmt = new TrainManagementModel();
        for (Train t : mgmt.getAllTrains()) {
            if (t.getTrainSource().equalsIgnoreCase(startLocation)
                    && !locations.contains(t.getTrainDestination())) {
                locations.add(t.getTrainDestination());
            }
        }
        return locations;
    }
}