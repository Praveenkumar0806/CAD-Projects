package com.zsgs.praveen.traintrace.features.trainmanagement;
import com.zsgs.praveen.traintrace.data.dto.Train;
import java.util.ArrayList;
import java.util.List;

public class TrainManagementModel {

    // ✅ Static — everywhere same list share aagum
    private static List<Train> allTrains = new ArrayList<>();

    static {
        allTrains.add(new Train(12661, "Pothigai Express", "ChennaiEgmore", "Sengottai"));
        allTrains.add(new Train(16101, "Kollam Express", "ChennaiEgmore", "Sengottai"));
        allTrains.add(new Train(12662, "Sengottai Special Express", "ChennaiEgmore", "Sengottai"));
        allTrains.add(new Train(12635, "Vaigai Express", "ChennaiEgmore", "Madurai"));
        allTrains.add(new Train(12636, "Pandian Express", "ChennaiEgmore", "Madurai"));
        allTrains.add(new Train(12110, "VandeBharat Express", "ChennaiEgmore", "Madurai"));
        allTrains.add(new Train(12694, "PearlCity Express", "ChennaiEgmore", "Tuticorin"));
        allTrains.add(new Train(22767, "Cholan Express", "ChennaiEgmore", "Mayiladuthurai"));
        allTrains.add(new Train(12680, "Nilagiri Express", "ChennaiEgmore", "Coimbatore"));
        allTrains.add(new Train(12631, "Nellai Express", "ChennaiEgmore", "Tirunelveli"));
        allTrains.add(new Train(20605, "Chendur Express", "ChennaiEgmore", "Tirunelveli"));
        allTrains.add(new Train(12630, "Ananthapuri Express", "ChennaiEgmore", "Tirunelveli"));
        allTrains.add(new Train(20681, "Silambu Express", "Srivilliputtur", "ChennaiEgmore"));
        allTrains.add(new Train(12660, "Pothigai Express", "Srivilliputtur", "ChennaiEgmore"));
        allTrains.add(new Train(16100, "Kollam Express", "Srivilliputtur", "ChennaiEgmore"));
        allTrains.add(new Train(12637, "Pandian Express", "Madurai", "Tambaram"));
        allTrains.add(new Train(12634, "Vaigai Express", "Madurai", "ChennaiEgmore"));
        allTrains.add(new Train(16808, "InterCity Express", "Mayiladuthurai", "ChennaiEgmore"));
        allTrains.add(new Train(12689, "MGR Central Express", "Coimbatore", "ChennaiEgmore"));
        allTrains.add(new Train(12604, "Palayankottai Express", "Tirunelveli", "ChennaiEgmore"));
        allTrains.add(new Train(12629, "SouthNellai Express", "Tirunelveli", "ChennaiEgmore"));
    }

    public void addTrain(Train train) {
        allTrains.add(train);
        System.out.println("Train " + train.getTrainName() + " added successfully!");
    }

    public boolean removeTrain(int trainNo) {
        for (int i = 0; i < allTrains.size(); i++) {
            if (allTrains.get(i).getTrainNo() == trainNo) {
                allTrains.remove(i);
                System.out.println("Train removed successfully!");
                return true;
            }
        }
        return false;
    }

    public List<Train> getAllTrains() {
        return allTrains;
    }
}