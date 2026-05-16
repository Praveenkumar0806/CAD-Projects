package data.dto;

public class Flights {
    private int  flightId;
    private String flightName;
    private String flightSource;
    private String flightDestination;
    private String flightDate;
    private String flightTime;
    private int flightTotalSeats;
    private int flightAvailableSeats;
    private double flightPrice;

    public Flights(int  flightId,String flightName,String flightSource,String flightDestination,String flightDate,String flightTime,int flightTotalSeats,int flightAvailableSeats,double flightPrice){
        this.flightId=flightId;
        this.flightName=flightName;
        this.flightSource=flightSource;
        this.flightDestination=flightDestination;
        this.flightDate=flightDate;
        this.flightTime=flightTime;
        this.flightTotalSeats=flightTotalSeats;
        this.flightAvailableSeats=flightAvailableSeats;
        this.flightPrice=flightPrice;
    }
    public int getFlightId(){
        return flightId;
    }
    public String getFlightName(){
        return flightName;
    }
    public String getFlightSource(){
        return flightSource;
    }
    public String getFlightDestination(){
        return flightDestination;
    }
    public String getFlightDate(){
        return flightDate;
    }
    public String getFlightTime(){
        return flightTime;
    }
    public int getFlightTotalSeats(){
        return flightTotalSeats;
    }
    public int getFlightAvailableSeats(){
        return flightAvailableSeats;
    }
    public double getFlightPrice(){
        return flightPrice;
    }

    public void setFlightId(int  flightId){
        this.flightId=flightId;
    }
    public void setFlightName(String flightName){
        this.flightName=flightName;
    }
    public void setFlightSource(String flightSource){
        this.flightSource=flightSource;
    }
    public void setFlightDestination(String flightDestination){
        this.flightDestination=flightDestination;
    }
    public void setFlightDate(String flightDate){
        this.flightDate=flightDate;
    }
    public void setFlightTime(String flightTime){
        this.flightTime=flightTime;
    }
    public void setFlightTotalSeats(int flightTotalSeats){
        this.flightTotalSeats=flightTotalSeats;
    }
    public void setFlightAvailableSeats(int flightAvailableSeats){
        this.flightAvailableSeats=flightAvailableSeats;
    }
    public void setFlightPrice(int flightPrice){
        this.flightPrice=flightPrice;
    }
}
