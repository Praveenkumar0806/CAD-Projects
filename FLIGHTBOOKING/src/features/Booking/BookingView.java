package features.Booking;
import data.dto.Bookings;
import data.dto.Flights;
import data.dto.User;
import java.util.ArrayList;
public class BookingView {
    BookingModel bookingModel;

    public BookingView(BookingModel bookingModel)
    {
        this.bookingModel=bookingModel;
    }
    public void bookingView()
    {
        ArrayList<Flights> flights = bookingModel.viewAllFlights();
        for (Flights flight : flights)
        {
            System.out.println("Flight ID             : "+flight.getFlightId()+"\n"+
                               "Flight Name           : "+flight.getFlightName()+"\n"+
                               "Flight source         : "+flight.getFlightSource()+"\n"+
                               "Flight Destination    : "+flight.getFlightDestination()+ "\n"+
                               "Flight Booking Date   : "+flight.getFlightDate()+"\n"+
                               "Flight Booking Time   : "+flight.getFlightTime()+"\n"+
                               "Flight Total Seat     : "+flight.getFlightTotalSeats()+"\n"+
                               "Flight Available Seat : "+flight.getFlightAvailableSeats()+"\n"+
                               "Flight Price          : "+flight.getFlightPrice());
        }
        System.out.println("-----------------------------------------------");
    }
    public void userBookingView(User user) {
        ArrayList<Bookings> myBookings = bookingModel.getMyBookings(user);
        if(myBookings.isEmpty()) {
            System.out.println("No Bookings Found!");
        }
        for(Bookings booking : myBookings) {
            System.out.println("Booking ID   : " + booking.getBookingId());
            System.out.println("User Name    : " +user.getUserName());
            System.out.println("User Name    : " +user.getUserMail());
            System.out.println("User Name    : " +user.getuserPhoneno());
            System.out.println("User Name    : " +user.getGender());
            System.out.println("Booking Date : " + booking.getBookingDate());
            System.out.println("Flight       : " + booking.getFlights().getFlightName());
            System.out.println("From         : " + booking.getFlights().getFlightSource());
            System.out.println("To           : " + booking.getFlights().getFlightDestination());
            System.out.println("-----------------------------------------------");
        }
    }
}
