package com.Project.praveen.traintrace.data.dto;

public class TrainStatus {
    private int trainNo;
    private String currentStation;
    private String statusMessage;

    public TrainStatus(int trainNo, String currentStation, String statusMessage) {
        this.trainNo = trainNo;
        this.currentStation = currentStation;
        this.statusMessage = statusMessage;
    }

    public int getTrainNo() { return trainNo; }
    public String getCurrentStation() { return currentStation; }
    public String getStatusMessage() { return statusMessage; }
}