package com.zsgs.praveen.traintrace.data.dto;

import java.time.LocalTime;

public class TrainStop {
    private String stationName;
    private LocalTime departureTime;

    public TrainStop(String stationName, int hour, int minute) {
        this.stationName = stationName;
        this.departureTime = LocalTime.of(hour, minute);
    }

    public String getStationName() { return stationName; }
    public LocalTime getDepartureTime() { return departureTime; }

    public String getFormattedTime() {
        return String.format("%02d:%02d", departureTime.getHour(), departureTime.getMinute());
    }
}