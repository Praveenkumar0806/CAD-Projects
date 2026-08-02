package features.Admin;
import data.dto.Flights;
import util.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class AdminModel {
    Scanner sc = new Scanner(System.in);

    public void addFlight() {
        System.out.println("Enter a Flight ID : ");
        int flightId = sc.nextInt(); sc.nextLine();
        System.out.println("Enter a Flight Name : ");
        String flightName = sc.nextLine();
        System.out.println("Enter your Flight Source : ");
        String flightSource = sc.nextLine();
        System.out.println("Enter a Flight Destination : ");
        String flightDestination = sc.nextLine();
        System.out.println("Enter a Flight Date (DD-MM-YY) : ");
        String flightDate = sc.nextLine();
        System.out.println("Enter a Flight Time : ");
        String flightTime = sc.nextLine();
        System.out.println("Enter a Flight TotalSeats : ");
        int totalSeats = sc.nextInt();
        System.out.println("Enter a Flight AvailableSeat : ");
        int availableSeats = sc.nextInt();
        System.out.println("Enter a Flight Price : ");
        double price = sc.nextDouble();

        String sql = "INSERT INTO flights VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, flightId);
            ps.setString(2, flightName);
            ps.setString(3, flightSource);
            ps.setString(4, flightDestination);
            ps.setString(5, flightDate);
            ps.setString(6, flightTime);
            ps.setInt(7, totalSeats);
            ps.setInt(8, availableSeats);
            ps.setDouble(9, price);
            ps.executeUpdate();
            System.out.println("Flight '" + flightName + "' Added Successfully!");
        } catch (SQLException e) {
            System.out.println("Add Flight Failed: " + e.getMessage());
        }
    }

    public void removeFlight() {
        System.out.println("Enter a Flight ID : ");
        int flightId = sc.nextInt(); sc.nextLine();

        String sql = "DELETE FROM flights WHERE flight_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, flightId);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Flight removed Successfully!.." : "Invalid Flight ID");
        } catch (SQLException e) {
            System.out.println("Remove Flight Failed: " + e.getMessage());
        }
    }

    public void updateFlight() {
        System.out.println("Enter a new Flight ID : ");
        int flightId = sc.nextInt();
        System.out.println("Enter new Price : ");
        double price = sc.nextDouble();
        System.out.println("Enter new Total Seats : ");
        int totalSeats = sc.nextInt();
        System.out.println("Enter new Available Seats : ");
        int availableSeats = sc.nextInt();

        String sql = "UPDATE flights SET flight_price=?, flight_total_seats=?, flight_available_seats=? WHERE flight_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, price);
            ps.setInt(2, totalSeats);
            ps.setInt(3, availableSeats);
            ps.setInt(4, flightId);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Flights Update Successfully!..." : "Invalid Flight ID!..");
        } catch (SQLException e) {
            System.out.println("Update Flight Failed: " + e.getMessage());
        }
    }
}