package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/flightbooking";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Test@123"; // idha ur password ku change pannu

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DB Connection Failed: " + e.getMessage());
        }
        return connection;
    }
}
