package com.Project.praveen.traintrace.features.trainmanagement;

import com.Project.praveen.traintrace.data.dto.Train;
import java.util.ArrayList;
import java.util.List;

public class TrainManagementModel {

    private static final List<Train> allTrains = new ArrayList<>();

    static {
        allTrains.add(new Train(12661, "Pothigai Express",       "ChennaiEgmore",  "Sengottai",       "Express",     "Daily"));
        allTrains.add(new Train(16101, "Kollam Express",         "ChennaiEgmore",  "Sengottai",       "Express",     "Daily"));
        allTrains.add(new Train(12662, "Sengottai SF Express",   "ChennaiEgmore",  "Sengottai",       "Superfast",   "Daily"));
        allTrains.add(new Train(12635, "Vaigai Express",         "ChennaiEgmore",  "Madurai",         "Express",     "Daily"));
        allTrains.add(new Train(12636, "Pandian Express",        "ChennaiEgmore",  "Madurai",         "Express",     "Daily"));
        allTrains.add(new Train(12110, "VandeBharat Express",    "ChennaiEgmore",  "Madurai",         "VandeBharat", "Daily"));
        allTrains.add(new Train(12694, "PearlCity Express",      "ChennaiEgmore",  "Tuticorin",       "Express",     "Daily"));
        allTrains.add(new Train(22767, "Cholan Express",         "ChennaiEgmore",  "Mayiladuthurai",  "Express",     "Daily"));
        allTrains.add(new Train(12680, "Nilagiri Express",       "ChennaiEgmore",  "Coimbatore",      "Express",     "Daily"));
        allTrains.add(new Train(12631, "Nellai Express",         "ChennaiEgmore",  "Tirunelveli",     "Express",     "Daily"));
        allTrains.add(new Train(20605, "Chendur Express",        "ChennaiEgmore",  "Tirunelveli",     "Express",     "Daily"));
        allTrains.add(new Train(12630, "Ananthapuri Express",    "ChennaiEgmore",  "Tirunelveli",     "Express",     "Daily"));
        allTrains.add(new Train(20681, "Silambu Express",        "Srivilliputtur", "ChennaiEgmore",   "Express",     "Daily"));
        allTrains.add(new Train(12660, "Pothigai Express",       "Srivilliputtur", "ChennaiEgmore",   "Express",     "Daily"));
        allTrains.add(new Train(16100, "Kollam Express",         "Srivilliputtur", "ChennaiEgmore",   "Express",     "Daily"));
        allTrains.add(new Train(12637, "Pandian Express",        "Madurai",        "Tambaram",        "Express",     "Daily"));
        allTrains.add(new Train(12634, "Vaigai Express",         "Madurai",        "ChennaiEgmore",   "Express",     "Daily"));
        allTrains.add(new Train(16808, "InterCity Express",      "Mayiladuthurai", "ChennaiEgmore",   "Express",     "Daily"));
        allTrains.add(new Train(12689, "MGR Central Express",    "Coimbatore",     "ChennaiEgmore",   "Express",     "Daily"));
        allTrains.add(new Train(12604, "Palayankottai Express",  "Tirunelveli",    "ChennaiEgmore",   "Express",     "Daily"));
        allTrains.add(new Train(12629, "SouthNellai Express",    "Tirunelveli",    "ChennaiEgmore",   "Express",     "Daily"));
    }

    public boolean addTrain(Train train) {
        for (Train t : allTrains) {
            if (t.getTrainNo() == train.getTrainNo()) return false;
        }
        allTrains.add(train);
        return true;
    }

    public boolean removeTrain(int trainNo) {
        return allTrains.removeIf(t -> t.getTrainNo() == trainNo);
    }

    public List<Train> getAllTrains() {
        return allTrains;
    }

    public Train findByNumber(int trainNo) {
        for (Train t : allTrains) {
            if (t.getTrainNo() == trainNo) return t;
        }
        return null;
    }
}