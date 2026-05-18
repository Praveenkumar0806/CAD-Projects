package com.zsgs.praveen.traintrace.features.livestatus;

import com.zsgs.praveen.traintrace.data.dto.TrainStop;
import java.util.*;
import java.time.LocalTime;

public class LiveStatusModel {

    private Map<Integer, List<TrainStop>> trainSchedule;

    public LiveStatusModel() {
        trainSchedule = new HashMap<>();


        trainSchedule.put(12661, Arrays.asList(
                new TrainStop("Chennai Egmore", 6, 20),
                new TrainStop("Tambaram", 7, 5),
                new TrainStop("Chengalpatu", 7, 45),
                new TrainStop("Villupuram", 9, 30),
                new TrainStop("Trichy Junction", 12, 0),
                new TrainStop("Dindigul Junction", 13, 30),
                new TrainStop("Madurai Junction", 15, 0),
                new TrainStop("Virudhunagar", 16, 10),
                new TrainStop("Rajapalayam", 17, 0),
                new TrainStop("Sengottai", 18, 30)
        ));


        trainSchedule.put(16101, Arrays.asList(
                new TrainStop("Chennai Egmore", 7, 0),
                new TrainStop("Tambaram", 7, 45),
                new TrainStop("Chengalpatu", 8, 20),
                new TrainStop("Villupuram", 10, 15),
                new TrainStop("Trichy Junction", 13, 0),
                new TrainStop("Dindigul Junction", 14, 30),
                new TrainStop("Madurai Junction", 16, 0),
                new TrainStop("Virudhunagar", 17, 10),
                new TrainStop("Rajapalayam", 18, 0),
                new TrainStop("Sengottai", 19, 30)
        ));


        trainSchedule.put(12662, Arrays.asList(
                new TrainStop("Chennai Egmore", 21, 0),
                new TrainStop("Tambaram", 21, 40),
                new TrainStop("Chengalpatu", 22, 10),
                new TrainStop("Villupuram", 23, 55),
                new TrainStop("Trichy Junction", 2, 30),
                new TrainStop("Dindigul Junction", 4, 0),
                new TrainStop("Madurai Junction", 5, 30),
                new TrainStop("Virudhunagar", 6, 40),
                new TrainStop("Rajapalayam", 7, 30),
                new TrainStop("Sengottai", 9, 0)
        ));


        trainSchedule.put(12635, Arrays.asList(
                new TrainStop("Chennai Egmore", 12, 15),
                new TrainStop("Tambaram", 12, 55),
                new TrainStop("Chengalpatu", 13, 25),
                new TrainStop("Villupuram", 15, 0),
                new TrainStop("Trichy Junction", 17, 30),
                new TrainStop("Dindigul Junction", 19, 0),
                new TrainStop("Madurai Junction", 20, 30)
        ));


        trainSchedule.put(12636, Arrays.asList(
                new TrainStop("Chennai Egmore", 21, 30),
                new TrainStop("Tambaram", 22, 10),
                new TrainStop("Chengalpatu", 22, 40),
                new TrainStop("Villupuram", 0, 25),
                new TrainStop("Trichy Junction", 3, 0),
                new TrainStop("Dindigul Junction", 4, 30),
                new TrainStop("Madurai Junction", 6, 0)
        ));


        trainSchedule.put(12110, Arrays.asList(
                new TrainStop("Chennai Egmore", 6, 0),
                new TrainStop("Villupuram", 8, 30),
                new TrainStop("Trichy Junction", 10, 45),
                new TrainStop("Dindigul Junction", 11, 55),
                new TrainStop("Madurai Junction", 13, 0)
        ));


        trainSchedule.put(12694, Arrays.asList(
                new TrainStop("Chennai Egmore", 7, 10),
                new TrainStop("Tambaram", 7, 50),
                new TrainStop("Chengalpatu", 8, 20),
                new TrainStop("Villupuram", 10, 5),
                new TrainStop("Trichy Junction", 12, 30),
                new TrainStop("Madurai Junction", 15, 0),
                new TrainStop("Virudhunagar", 16, 10),
                new TrainStop("Kovilpatti", 17, 0),
                new TrainStop("Tuticorin", 18, 30)
        ));


        trainSchedule.put(22767, Arrays.asList(
                new TrainStop("Chennai Egmore", 6, 50),
                new TrainStop("Tambaram", 7, 30),
                new TrainStop("Chengalpatu", 8, 0),
                new TrainStop("Villupuram", 9, 45),
                new TrainStop("Vridhachalam", 10, 30),
                new TrainStop("Mayiladuthurai", 12, 30)
        ));


        trainSchedule.put(12680, Arrays.asList(
                new TrainStop("Chennai Egmore", 21, 15),
                new TrainStop("Tambaram", 21, 55),
                new TrainStop("Chengalpatu", 22, 25),
                new TrainStop("Villupuram", 0, 10),
                new TrainStop("Trichy Junction", 2, 45),
                new TrainStop("Dindigul Junction", 4, 15),
                new TrainStop("Coimbatore", 7, 0)
        ));


        trainSchedule.put(12631, Arrays.asList(
                new TrainStop("Chennai Egmore", 19, 0),
                new TrainStop("Tambaram", 19, 40),
                new TrainStop("Chengalpatu", 20, 10),
                new TrainStop("Villupuram", 21, 55),
                new TrainStop("Trichy Junction", 0, 30),
                new TrainStop("Madurai Junction", 3, 0),
                new TrainStop("Virudhunagar", 4, 10),
                new TrainStop("Kovilpatti", 5, 0),
                new TrainStop("Tirunelveli", 6, 15)
        ));


        trainSchedule.put(20605, Arrays.asList(
                new TrainStop("Chennai Egmore", 15, 0),
                new TrainStop("Tambaram", 15, 40),
                new TrainStop("Chengalpatu", 16, 10),
                new TrainStop("Villupuram", 17, 55),
                new TrainStop("Trichy Junction", 20, 30),
                new TrainStop("Madurai Junction", 23, 0),
                new TrainStop("Virudhunagar", 0, 10),
                new TrainStop("Kovilpatti", 1, 0),
                new TrainStop("Tirunelveli", 2, 15)
        ));


        trainSchedule.put(12630, Arrays.asList(
                new TrainStop("Chennai Egmore", 20, 30),
                new TrainStop("Tambaram", 21, 10),
                new TrainStop("Chengalpatu", 21, 40),
                new TrainStop("Villupuram", 23, 25),
                new TrainStop("Trichy Junction", 2, 0),
                new TrainStop("Madurai Junction", 4, 30),
                new TrainStop("Virudhunagar", 5, 40),
                new TrainStop("Kovilpatti", 6, 30),
                new TrainStop("Tirunelveli", 7, 45)
        ));


        trainSchedule.put(20681, Arrays.asList(
                new TrainStop("Srivilliputtur", 5, 0),
                new TrainStop("Rajapalayam", 5, 45),
                new TrainStop("Virudhunagar", 6, 30),
                new TrainStop("Madurai Junction", 7, 45),
                new TrainStop("Dindigul Junction", 9, 0),
                new TrainStop("Trichy Junction", 10, 30),
                new TrainStop("Villupuram", 13, 15),
                new TrainStop("Chengalpatu", 15, 0),
                new TrainStop("Tambaram", 15, 30),
                new TrainStop("Chennai Egmore", 16, 15)
        ));


        trainSchedule.put(12660, Arrays.asList(
                new TrainStop("Srivilliputtur", 18, 0),
                new TrainStop("Rajapalayam", 18, 45),
                new TrainStop("Virudhunagar", 19, 30),
                new TrainStop("Madurai Junction", 20, 45),
                new TrainStop("Dindigul Junction", 22, 0),
                new TrainStop("Trichy Junction", 23, 30),
                new TrainStop("Villupuram", 2, 15),
                new TrainStop("Chengalpatu", 4, 0),
                new TrainStop("Tambaram", 4, 30),
                new TrainStop("Chennai Egmore", 5, 15)
        ));


        trainSchedule.put(16100, Arrays.asList(
                new TrainStop("Srivilliputtur", 9, 0),
                new TrainStop("Rajapalayam", 9, 45),
                new TrainStop("Virudhunagar", 10, 30),
                new TrainStop("Madurai Junction", 11, 45),
                new TrainStop("Dindigul Junction", 13, 0),
                new TrainStop("Trichy Junction", 14, 30),
                new TrainStop("Villupuram", 17, 15),
                new TrainStop("Chengalpatu", 19, 0),
                new TrainStop("Tambaram", 19, 30),
                new TrainStop("Chennai Egmore", 20, 15)
        ));


        trainSchedule.put(12637, Arrays.asList(
                new TrainStop("Madurai Junction", 19, 45),
                new TrainStop("Dindigul Junction", 21, 0),
                new TrainStop("Trichy Junction", 22, 30),
                new TrainStop("Villupuram", 1, 15),
                new TrainStop("Chengalpatu", 3, 0),
                new TrainStop("Tambaram", 3, 30)
        ));


        trainSchedule.put(12634, Arrays.asList(
                new TrainStop("Madurai Junction", 14, 0),
                new TrainStop("Dindigul Junction", 15, 10),
                new TrainStop("Trichy Junction", 16, 30),
                new TrainStop("Villupuram", 19, 0),
                new TrainStop("Chengalpatu", 20, 30),
                new TrainStop("Tambaram", 21, 0),
                new TrainStop("Chennai Egmore", 21, 40)
        ));


        trainSchedule.put(16808, Arrays.asList(
                new TrainStop("Mayiladuthurai", 6, 0),
                new TrainStop("Vridhachalam", 7, 45),
                new TrainStop("Villupuram", 8, 45),
                new TrainStop("Chengalpatu", 10, 30),
                new TrainStop("Tambaram", 11, 0),
                new TrainStop("Chennai Egmore", 11, 45)
        ));


        trainSchedule.put(12689, Arrays.asList(
                new TrainStop("Coimbatore", 21, 30),
                new TrainStop("Dindigul Junction", 23, 45),
                new TrainStop("Trichy Junction", 1, 15),
                new TrainStop("Villupuram", 4, 0),
                new TrainStop("Chengalpatu", 5, 30),
                new TrainStop("Tambaram", 6, 0),
                new TrainStop("Chennai Egmore", 6, 45)
        ));


        trainSchedule.put(12604, Arrays.asList(
                new TrainStop("Tirunelveli", 19, 0),
                new TrainStop("Kovilpatti", 20, 10),
                new TrainStop("Virudhunagar", 21, 0),
                new TrainStop("Madurai Junction", 22, 15),
                new TrainStop("Dindigul Junction", 23, 30),
                new TrainStop("Trichy Junction", 1, 0),
                new TrainStop("Villupuram", 3, 45),
                new TrainStop("Chengalpatu", 5, 30),
                new TrainStop("Tambaram", 6, 0),
                new TrainStop("Chennai Egmore", 6, 45)
        ));


        trainSchedule.put(12629, Arrays.asList(
                new TrainStop("Tirunelveli", 7, 30),
                new TrainStop("Kovilpatti", 8, 40),
                new TrainStop("Virudhunagar", 9, 30),
                new TrainStop("Madurai Junction", 10, 45),
                new TrainStop("Dindigul Junction", 12, 0),
                new TrainStop("Trichy Junction", 13, 30),
                new TrainStop("Villupuram", 16, 15),
                new TrainStop("Chengalpatu", 18, 0),
                new TrainStop("Tambaram", 18, 30),
                new TrainStop("Chennai Egmore", 19, 15)
        ));
    }

    public String getStatus(int trainNo) {
        List<TrainStop> stops = trainSchedule.get(trainNo);

        if (stops == null) {
            return "Tracking data not available for this train!";
        }

        LocalTime now = LocalTime.now();
        int nowTotal = now.getHour() * 60 + now.getMinute();

        TrainStop currentStop = null;

        for (TrainStop stop : stops) {
            int stopTotal = stop.getDepartureHour() * 60 + stop.getDepartureMinute();
            if (nowTotal >= stopTotal) {
                currentStop = stop;
            }
        }

        if (currentStop == null) {
            return "Train Not Yet Started | First Station: "
                    + stops.get(0).getStationName()
                    + " at " + formatTime(stops.get(0).getDepartureHour(), stops.get(0).getDepartureMinute());
        }

        TrainStop lastStop = stops.get(stops.size() - 1);
        int lastTotal = lastStop.getDepartureHour() * 60 + lastStop.getDepartureMinute();
        if (nowTotal >= lastTotal) {
            return "Train Reached Destination: " + lastStop.getStationName();
        }

        return "Currently at/passed: " + currentStop.getStationName()
                + " | Departed at: " + formatTime(currentStop.getDepartureHour(), currentStop.getDepartureMinute());
    }
    public String getFullSchedule(int trainNo) {
        List<TrainStop> stops = trainSchedule.get(trainNo);

        if (stops == null) {
            return "Schedule not available for this train!";
        }

        LocalTime now = LocalTime.now();
        int nowTotal = now.getHour() * 60 + now.getMinute();

        StringBuilder sb = new StringBuilder();
        sb.append("\n--------Full Schedule--------\n");

        for (int i = 0; i < stops.size(); i++) {
            TrainStop stop = stops.get(i);
            int stopTotal = stop.getDepartureHour() * 60 + stop.getDepartureMinute();

            String time = formatTime(stop.getDepartureHour(), stop.getDepartureMinute());

            if (stopTotal > nowTotal) {
                // Upcoming station
                sb.append("  [ ] " + stop.getStationName() + " - " + time + " (upcoming)\n");
            } else if (i + 1 < stops.size()) {
                int nextTotal = stops.get(i + 1).getDepartureHour() * 60 + stops.get(i + 1).getDepartureMinute();
                if (nowTotal < nextTotal) {
                    // Train is HERE now
                    sb.append("  >>> " + stop.getStationName() + " - " + time + " << TRAIN IS HERE >>\n");
                } else {
                    // Already departed
                    sb.append("  [✓] " + stop.getStationName() + " - " + time + " (departed)\n");
                }
            } else {
                // Last station
                if (nowTotal >= stopTotal) {
                    sb.append("  [✓] " + stop.getStationName() + " - " + time + " (Reached Destination)\n");
                } else {
                    sb.append("  [ ] " + stop.getStationName() + " - " + time + " (upcoming)\n");
                }
            }
        }

        sb.append("-----------------------------");
        return sb.toString();
    }

    private String formatTime(int hour, int minute) {
        return String.format("%02d:%02d", hour, minute);
    }
}