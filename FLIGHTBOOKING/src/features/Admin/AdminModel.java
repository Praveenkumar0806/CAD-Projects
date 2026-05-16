package features.Admin;
import data.dto.Flights;
import java.util.Scanner;
import java.util.ArrayList;

public class AdminModel {
    public ArrayList<Flights> flightList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addFlight() {

        System.out.println("Enter a Flight ID : ");
        int flightId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter a Flight Name : ");
        String flightName=sc.nextLine();

        System.out.println("Enter your Flight Source : ");
        String flightSource=sc.nextLine();

        System.out.println("Enter a Flight Destination : ");
        String flightDestination=sc.nextLine();

        System.out.println("Enter a Flight Date (DD-MM-YY) : ");
        String flightDate=sc.nextLine();

        System.out.println("Enter a Flight Time : ");
        String flightTime=sc.nextLine();

        System.out.println("Enter a Flight TotalSeats : ");
        int flightTotalSeat=sc.nextInt();

        System.out.println("Enter a Flight AvailableSeat : ");
        int flightAvailableSeat=sc.nextInt();

        System.out.println("Enter a Flight Price : ");
        int flightPrice=sc.nextInt();

        Flights flights = new Flights(flightId,flightName,flightSource,flightDestination,flightDate,flightTime,flightTotalSeat,flightAvailableSeat,flightPrice);
        flightList.add(flights);

        System.out.println("\n=============================================");
        System.out.println("  Flight '" + flightName + "' Added Successfully!");
        System.out.println("=============================================\n");

    }
    public void removeFlight(){
        System.out.println("Enter a Flight ID : ");
        int flightId=sc.nextInt();
        sc.nextLine();

        Flights flightToRemove = null;
        for (Flights flights : flightList) {
            if (flights.getFlightId() == flightId) {
                flightToRemove = flights;
                break;
            }
        }

        if (flightToRemove != null) {
            flightList.remove(flightToRemove);
            System.out.println("Flight removed Successfully!..");
        } else {
            System.out.println("Invalid Flight ID \nPlease Enter Valid FlightId..");
        }
    }
    public void updateFlight(){
        System.out.println("Enter a new Flight ID : ");
        int flightID = sc.nextInt();
        boolean found=false;
        for(Flights flights : flightList)
        {
            if(flights.getFlightId() == flightID)
            {
                found=true;
                System.out.println("Enter new Price : ");
                int price = sc.nextInt();

                System.out.println("Enter new Total Seats : ");
                int totalSeats = sc.nextInt();

                System.out.println("Enter new Available Seats : ");
                int availableSeats = sc.nextInt();

                flights.setFlightPrice(price);
                flights.setFlightTotalSeats(totalSeats);
                flights.setFlightAvailableSeats(availableSeats);

                System.out.println("Flights Update Successfully!...");
                System.out.println("----------------------------------------------------");
                break;
            }
        }
        if(!found)
        {
            System.out.println("Sorry !.. \n Invalid FLight ID!..");
        }
    }
}
