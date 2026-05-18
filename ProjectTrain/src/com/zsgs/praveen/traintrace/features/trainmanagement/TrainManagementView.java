package com.zsgs.praveen.traintrace.features.trainmanagement;
import com.zsgs.praveen.traintrace.data.dto.Train;
import java.util.Scanner;

public class TrainManagementView {
    private TrainManagementModel trainManagementModel = new TrainManagementModel();
    private Scanner sc = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("-----Admin Management!-----");
            System.out.println("1.Add New Trains");
            System.out.println("2.Remove Train");
            System.out.println("3.View All Trains");
            System.out.println("4.Exit!..");

            System.out.println("Enter Your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addNewTrain();
                    break;
                case 2:
                    deleteTrain();
                    break;
                case 3:
                    viewTrains();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void addNewTrain() {
        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Train Name: ");
        String trainName = sc.nextLine();
        System.out.print("Enter Source: ");
        String trainStartPlace = sc.nextLine();
        System.out.print("Enter Destination: ");
        String trainEndPlace = sc.nextLine();

        Train newTrain = new Train(trainNo, trainName, trainStartPlace, trainEndPlace);
        trainManagementModel.addTrain(newTrain);
    }

    private void deleteTrain() {
        System.out.print("Enter Train Number to remove: ");
        int no = sc.nextInt();
        if (trainManagementModel.removeTrain(no)) {
            System.out.println("Train removed.");
        } else {
            System.out.println("Train not found!");
        }
    }

    private void viewTrains() {
        System.out.println("  List of all trains : ");
        for (Train t : trainManagementModel.getAllTrains()) {
            System.out.println(t.getTrainNo() + " - " + t.getTrainName());
        }
    }
}