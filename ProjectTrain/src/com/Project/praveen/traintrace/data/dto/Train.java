package com.zsgs.praveen.traintrace.data.dto;

public class Train {
    private int trainNo;
    private String trainName;
    private String trainSource;
    private String trainDestination;
    private String type;
    private String daysOfRunning;

    public Train(int trainNo, String trainName, String trainSource, String trainDestination, String type, String daysOfRunning) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.trainSource = trainSource;
        this.trainDestination = trainDestination;
        this.type = type;
        this.daysOfRunning = daysOfRunning;
    }

    public int getTrainNo() { return trainNo; }
    public String getTrainName() { return trainName; }
    public String getTrainSource() { return trainSource; }
    public String getTrainDestination() { return trainDestination; }
    public String getType() { return type; }
    public String getDaysOfRunning() { return daysOfRunning; }

    public void setTrainNo(int trainNo) { this.trainNo = trainNo; }
    public void setTrainName(String trainName) { this.trainName = trainName; }
    public void setTrainSource(String trainSource) { this.trainSource = trainSource; }
    public void setTrainDestination(String trainDestination) { this.trainDestination = trainDestination; }
    public void setType(String type) { this.type = type; }
    public void setDaysOfRunning(String daysOfRunning) { this.daysOfRunning = daysOfRunning; }
}