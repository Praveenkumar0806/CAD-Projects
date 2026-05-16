package features.Flight;
import data.dto.Flights;
import features.Admin.AdminModel;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightModel {
    AdminModel adminModel;
    public FlightModel(AdminModel adminModel)
    {
        this.adminModel=adminModel;
    }

    public ArrayList<Flights> getAllFlight()
    {
        return adminModel.flightList;
    }
    public ArrayList<Flights> searchFlight()
    {
        ArrayList<Flights> matchedFlights = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Source : ");
        String source = sc.nextLine();

        System.out.println("Enter your Destination : ");
        String destination = sc.nextLine();

        for(Flights flights: adminModel.flightList)
        {
            if(flights.getFlightSource().equalsIgnoreCase(source) && flights.getFlightDestination().equalsIgnoreCase(destination))
            {
                matchedFlights.add(flights);
            }
        }
        return matchedFlights;
    }
}
