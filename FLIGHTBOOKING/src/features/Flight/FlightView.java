package features.Flight;

import data.dto.Flights;
import java.util.ArrayList;

public class FlightView {
    FlightModel flightModel;
    public FlightView(FlightModel flightModel)
    {
        this.flightModel=flightModel;
    }
    public void showAllFlights()
    {
        ArrayList<Flights> flights = flightModel.getAllFlight();
        if (flights.isEmpty()) {
            System.out.println("\nNo Flights Available Currently!");
            System.out.println("-----------------------------------------------");
            return;
        }
        System.out.println("\n---------------- AVAILABLE FLIGHTS ----------------");
        for(Flights flight : flights)
        {
            System.out.println( "Flight ID              : "+flight.getFlightId()+"\n"+
                                "Flight Name            : "+flight.getFlightName()+"\n"+
                                "Flight Source          : "+flight.getFlightSource()+"\n"+
                                "Flight Destination     : "+flight.getFlightDestination()+"\n"+
                                "Flight Available Date  : "+flight.getFlightDate()+"\n"+
                                "Flight Time            : "+flight.getFlightTime()+"\n"+
                                "Flight Total Seats     : "+flight.getFlightTotalSeats()+"\n"+
                                "Flight Available Seat  : "+flight.getFlightAvailableSeats()+"\n"+
                                "Flight Price           : "+flight.getFlightPrice());
            System.out.println("-----------------------------------------------");
        }

    }
    public void showSearchFlights() {
        ArrayList<Flights> list = flightModel.searchFlight();
        for (Flights flight : list) {
            System.out.println( flight.getFlightId() + "\n" +
                                flight.getFlightName() + "\n" +
                                flight.getFlightSource() + "\n" +
                                flight.getFlightDestination() + "\n" +
                                flight.getFlightDate() + "\n" +
                                flight.getFlightTime() + "\n" +
                                flight.getFlightTotalSeats() + "\n" +
                                flight.getFlightAvailableSeats() + "\n" +
                                flight.getFlightPrice());
        }
        System.out.println("-----------------------------------------------");
    }
}
