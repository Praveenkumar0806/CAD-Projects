package features.Booking;
import data.dto.Bookings;
import data.dto.Flights;
import data.dto.User;
import features.Flight.FlightModel;
import util.DBConnection;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BookingModel {
    FlightModel flightModel;
    Scanner sc = new Scanner(System.in);

    public BookingModel(FlightModel flightModel) {
        this.flightModel = flightModel;
    }

    public ArrayList<Flights> viewAllFlights() {
        return flightModel.getAllFlight();
    }

    public void bookingFlight(User user) {
        System.out.println("Enter a Flight ID : ");
        int flightId = sc.nextInt(); sc.nextLine();

        try (Connection con = DBConnection.getConnection()) {
            // Check seats
            PreparedStatement checkPs = con.prepareStatement("SELECT flight_available_seats FROM flights WHERE flight_id=?");
            checkPs.setInt(1, flightId);
            ResultSet rs = checkPs.executeQuery();

            if (!rs.next()) {
                System.out.println("Sorry!.. \n Invalid Flight ID");
                return;
            }
            int available = rs.getInt("flight_available_seats");
            if (available <= 0) {
                System.out.println("Sorry! No seats available in this flight.");
                return;
            }

            System.out.print("Enter a DATE (DD-MM-YY): ");
            String bookingDate = sc.nextLine();

            // Insert booking
            PreparedStatement insertPs = con.prepareStatement(
                    "INSERT INTO bookings (booking_date, user_id, flight_id) VALUES (?,?,?)");
            insertPs.setString(1, bookingDate);
            insertPs.setInt(2, user.getUserId());
            insertPs.setInt(3, flightId);
            insertPs.executeUpdate();

            // Reduce seat
            PreparedStatement updatePs = con.prepareStatement(
                    "UPDATE flights SET flight_available_seats = flight_available_seats - 1 WHERE flight_id=?");
            updatePs.setInt(1, flightId);
            updatePs.executeUpdate();

            System.out.println("Booking Successfully!..\nHAPPY JOURNEY");

        } catch (SQLException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }
    }

    public ArrayList<Bookings> getMyBookings(User user) {
        ArrayList<Bookings> myBookings = new ArrayList<>();
        String sql = "SELECT b.booking_id, b.booking_date, f.* FROM bookings b JOIN flights f ON b.flight_id = f.flight_id WHERE b.user_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, user.getUserId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flights f = new Flights(
                        rs.getInt("flight_id"), rs.getString("flight_name"),
                        rs.getString("flight_source"), rs.getString("flight_destination"),
                        rs.getString("flight_date"), rs.getString("flight_time"),
                        rs.getInt("flight_total_seats"), rs.getInt("flight_available_seats"),
                        rs.getDouble("flight_price"));
                myBookings.add(new Bookings(rs.getInt("booking_id"), rs.getString("booking_date"), user, f));
            }
        } catch (SQLException e) {
            System.out.println("Fetch Bookings Failed: " + e.getMessage());
        }
        return myBookings;
    }
}