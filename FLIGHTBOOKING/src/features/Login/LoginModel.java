package features.Login;
import data.dto.User;
import features.SignUp.SignUpModel;
import util.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class LoginModel {
    SignUpModel signUpModel;

    public LoginModel(SignUpModel signUpModel) {
        this.signUpModel = signUpModel;
    }

    public User login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your USER ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your USER PASSWORD : ");
        String password = sc.nextLine();

        String sql = "SELECT * FROM users WHERE user_id=? AND user_password=?";
        User loggedUser = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                loggedUser = new User(
                        rs.getInt("user_id"), rs.getInt("user_age"),
                        rs.getString("user_password"), rs.getString("user_name"),
                        rs.getString("user_dob"), rs.getString("user_phoneno"),
                        rs.getString("user_mail"), rs.getString("gender"));
            }
        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
        }

        if (loggedUser != null) {
            System.out.println("Login Successfully!...");
        } else {
            System.out.println("Invalid ID & PASSWORD \n If new User Please SIGNUP!..");
        }
        return loggedUser;
    }
}