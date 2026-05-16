package features.Booking;
import data.dto.Bookings;
import data.dto.Flights;
import data.dto.User;
import features.Flight.FlightModel;
import java.util.Scanner;
import java.util.ArrayList;

public class BookingModel {
    FlightModel flightModel;
    public BookingModel(FlightModel flightModel)
    {
        this.flightModel=flightModel;
    }
    ArrayList<Bookings>  bookingList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ArrayList<Flights> viewAllFlights() {
        return flightModel.getAllFlight();
    }

    public void bookingFlight(User user)
    {
        boolean found=false;
        System.out.println("Enter a Flight ID : ");
        int flightID = sc.nextInt();
        sc.nextLine();
        for(Flights flights : flightModel.getAllFlight())
        {
            if(flights.getFlightId() == flightID)
            {
                found = true;
                if(flights.getFlightAvailableSeats() <= 0) {
                    System.out.println("Sorry! No seats available in this flight.");
                    return;
                }

                int bookingId = bookingList.size() + 1;
                System.out.print("Enter a DATE (DD-MM-YY): ");
                String bookingDate = sc.nextLine();


                flights.setFlightAvailableSeats(flights.getFlightAvailableSeats() - 1);

                Bookings bookings = new Bookings(bookingId, bookingDate, user, flights);
                bookingList.add(bookings);

                System.out.println("Booking Successfully!..\nHAPPY JOURNEY");
                System.out.println("---------------------------------------------");
                break;
            }
        }
        if(!found)
        {
            System.out.println("Sorry!.. \n Invalid Flight ID");
        }
    }
    public ArrayList<Bookings> getMyBookings(User user) {
        ArrayList<Bookings> myBookings = new ArrayList<>();
        for(Bookings booking : bookingList) {
            if(booking.getUser().getUserId() == user.getUserId()) {
                myBookings.add(booking);
            }
        }
        return myBookings;
    }
}
