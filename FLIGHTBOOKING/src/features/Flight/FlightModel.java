package features.Flight;
import data.dto.Flights;
import features.Admin.AdminModel;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightModel {
    AdminModel adminModel;
    public FlightModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    public ArrayList<Flights> getAllFlight() {
        ArrayList<Flights> list = new ArrayList<>();
        String sql = "SELECT * FROM flights";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Flights(
                        rs.getInt("flight_id"), rs.getString("flight_name"),
                        rs.getString("flight_source"), rs.getString("flight_destination"),
                        rs.getString("flight_date"), rs.getString("flight_time"),
                        rs.getInt("flight_total_seats"), rs.getInt("flight_available_seats"),
                        rs.getDouble("flight_price")));
            }
        } catch (SQLException e) {
            System.out.println("Fetch Flights Failed: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Flights> searchFlight() {
        ArrayList<Flights> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Source : ");
        String source = sc.nextLine();
        System.out.println("Enter your Destination : ");
        String destination = sc.nextLine();

        String sql = "SELECT * FROM flights WHERE flight_source=? AND flight_destination=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, source);
            ps.setString(2, destination);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Flights(
                        rs.getInt("flight_id"), rs.getString("flight_name"),
                        rs.getString("flight_source"), rs.getString("flight_destination"),
                        rs.getString("flight_date"), rs.getString("flight_time"),
                        rs.getInt("flight_total_seats"), rs.getInt("flight_available_seats"),
                        rs.getDouble("flight_price")));
            }
        } catch (SQLException e) {
            System.out.println("Search Flight Failed: " + e.getMessage());
        }
        return list;
    }
}