package com.zsgs.praveen.traintrace.features.livestatus;
import java.util.Scanner;
public class LiveStatusView {
    private LiveStatusModel model;
    Scanner sc=new Scanner(System.in);
    public LiveStatusView()
    {
        this.model=new LiveStatusModel();
    }

    public void showTrainStatus()
    {
        System.out.println("-----Live Train Status-----");
        System.out.println("Enter a Train Number : ");

        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid Train Number!");
            sc.next();
        }

        int trainNo = sc.nextInt();
        String status = model.getStatus(trainNo);

        System.out.println("---------------------------------");
        System.out.println("TRAIN NO: " + trainNo);
        System.out.println("CURRENT STATUS: " + status);
        System.out.println("---------------------------------");
    }
}
