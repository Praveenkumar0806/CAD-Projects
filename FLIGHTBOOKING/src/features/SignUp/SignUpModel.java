package features.SignUp;
import data.dto.User;
import util.DBConnection;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

public class SignUpModel {
    public ArrayList<User> userList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addUsers() {
        System.out.println("Enter your  ID : ");
        int userId = sc.nextInt();
        System.out.println("Enter your  AGE : ");
        int userAge = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your  PASSWORD : ");
        String userPassword = sc.nextLine();
        System.out.println("Enter your  NAME : ");
        String userName = sc.nextLine();
        System.out.println("Enter your DOB (DD-MM-YY) : ");
        String userDOB = sc.nextLine();
        System.out.println("Enter your PHONE NO : ");
        String userPhoneno = sc.nextLine();
        System.out.println("Enter your G-MAIL : ");
        String userMail = sc.nextLine();
        System.out.println("Enter your GENDER : (Male / Female)  ");
        String gender = sc.nextLine();

        String sql = "INSERT INTO users (user_id, user_age, user_password, user_name, user_dob, user_phoneno, user_mail, gender) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, userAge);
            ps.setString(3, userPassword);
            ps.setString(4, userName);
            ps.setString(5, userDOB);
            ps.setString(6, userPhoneno);
            ps.setString(7, userMail);
            ps.setString(8, gender);

            ps.executeUpdate();
            System.out.println("SignUp Saved to DB Successfully!");

        } catch (SQLException e) {
            System.out.println("SignUp Failed: " + e.getMessage());
        }
    }
}
