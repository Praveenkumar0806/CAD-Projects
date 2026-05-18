package com.zsgs.praveen.traintrace.features.trainsearch;
import com.zsgs.praveen.traintrace.data.dto.Train;
import com.zsgs.praveen.traintrace.features.trainmanagement.TrainManagementModel;
import java.util.ArrayList;
import java.util.List;

public class TrainSearchModel {

    private TrainManagementModel trainManagementModel;

    public TrainSearchModel() {
        this.trainManagementModel = new TrainManagementModel();
    }

    public List<Train> findTrains(String startLocation, String endLocation) {
        List<Train> filterTrains = new ArrayList<>();

        for (Train t : trainManagementModel.getAllTrains()) {
            if (t.getTrainSource().equalsIgnoreCase(startLocation)
                    && t.getTrainDestination().equalsIgnoreCase(endLocation)) {
                filterTrains.add(t);
            }
        }
        return filterTrains;
    }
}