package com.zsgs.praveen.traintrace.data.dto;

public class TrainStop {
    private String stationName;
    private int departureHour;
    private int departureMinute;

    public TrainStop(String stationName, int departureHour, int departureMinute) {
        this.stationName = stationName;
        this.departureHour = departureHour;
        this.departureMinute = departureMinute;
    }

    public String getStationName() { return stationName; }
    public int getDepartureHour() { return departureHour; }
    public int getDepartureMinute() { return departureMinute; }
}
