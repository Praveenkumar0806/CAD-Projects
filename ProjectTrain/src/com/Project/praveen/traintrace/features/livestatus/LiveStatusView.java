package com.zsgs.praveen.traintrace.features.livestatus;

import com.zsgs.praveen.traintrace.util.AppScanner;
import java.util.Scanner;

public class LiveStatusView {
    private final LiveStatusModel liveStatusModel = new LiveStatusModel();
    private final Scanner sc = AppScanner.get();

    public void showTrainStatus() {
        System.out.println("\n===== Live Train Status =====");
        System.out.print("Enter Train Number: ");
        try {
            int trainNo = Integer.parseInt(sc.nextLine().trim());
            System.out.println("---------------------------------");
            System.out.println("TRAIN NO      : " + trainNo);
            System.out.println("CURRENT STATUS: " + liveStatusModel.getStatus(trainNo));
            System.out.println("---------------------------------");
        } catch (NumberFormatException e) {
            System.out.println("Invalid train number!");
        }
    }

    public void showFullSchedule(int trainNo, String trainName) {
        System.out.println("\n---------------------------------");
        System.out.println("TRAIN NO   : " + trainNo);
        System.out.println("TRAIN NAME : " + trainName);
        System.out.println(liveStatusModel.getFullSchedule(trainNo));
        System.out.println("---------------------------------");
    }
}