package com.zsgs.praveen.traintrace.features.trainsearch;

import com.zsgs.praveen.traintrace.data.dto.Train;
import com.zsgs.praveen.traintrace.features.trainmanagement.TrainManagementModel;
import java.util.ArrayList;
import java.util.List;

public class TrainSearchModel {
    private final TrainManagementModel trainManagementModel = new TrainManagementModel();

    public List<Train> findTrains(String source, String destination) {
        List<Train> result = new ArrayList<>();
        for (Train t : trainManagementModel.getAllTrains()) {
            if (t.getTrainSource().equalsIgnoreCase(source)
                    && t.getTrainDestination().equalsIgnoreCase(destination)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<String> getUniqueSources() {
        List<String> locations = new ArrayList<>();
        for (Train t : trainManagementModel.getAllTrains()) {
            if (!locations.contains(t.getTrainSource())) locations.add(t.getTrainSource());
        }
        return locations;
    }

    public List<String> getDestinationsFrom(String source) {
        List<String> locations = new ArrayList<>();
        for (Train t : trainManagementModel.getAllTrains()) {
            if (t.getTrainSource().equalsIgnoreCase(source)
                    && !locations.contains(t.getTrainDestination())) {
                locations.add(t.getTrainDestination());
            }
        }
        return locations;
    }
}