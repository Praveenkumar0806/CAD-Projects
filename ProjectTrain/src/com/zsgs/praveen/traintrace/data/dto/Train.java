package com.zsgs.praveen.traintrace.data.dto;
import java.util.List;

public class Train {

   private int trainNo;
   private String trainName;
   private String trainSource;
   private String trainDestination;
   private List<String> daysOfRunning;
   private String type;

   public Train(int trainNo,String trainName,String trainSource,String trainDestination)
   {
       this.trainNo = trainNo;
       this.trainName = trainName;
       this.trainSource = trainSource;
       this.trainDestination = trainDestination;
   }

   public int getTrainNo() {
       return trainNo;
   }
   public String getTrainName() {
       return trainName;
   }
   public String getTrainSource() {
       return trainSource;
   }
   public String getTrainDestination() {
       return trainDestination;
   }

   public void setTrainNo(int trainNo) {
       this.trainNo = trainNo;
   }
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
    public void setTrainSource(String trainSource) {
        this.trainSource = trainSource;
    }
    public void setTrainDestination(String trainDestination) {
        this.trainDestination = trainDestination;
    }
}
