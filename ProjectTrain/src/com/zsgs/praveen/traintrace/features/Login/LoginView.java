package com.zsgs.praveen.traintrace.features.Login;
import com.zsgs.praveen.traintrace.features.trainsearch.TrainSearchView;
import com.zsgs.praveen.traintrace.features.trainmanagement.TrainManagementView;
import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    private Scanner sc = new Scanner(System.in);

    public LoginView() {
        this.loginModel = new LoginModel();
    }

    public void init() {
        while (true) {
            System.out.println("-----Welcome to Train Tracking System-----");
            System.out.println("1. Login");
            System.out.println("2. Sign Up (New User)");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    proceedToLogin();
                    break;
                case 2:
                    proceedToSignUp();
                    break;
                case 3:
                    System.out.println("Thank you for using TrainTrace. Bye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public void proceedToSignUp() {
        System.out.println("-----New User Registration-----");
        System.out.println("Enter your Name : ");
        String name = sc.nextLine();
        System.out.println("Enter your Password : ");
        String password = sc.nextLine();
        System.out.println("Enter your Mobile Number : ");
        String mobile = sc.nextLine();

        if (mobile.length() == 10) {
            loginModel.registration(name, password, mobile);
            System.out.println("Registration Successful! You can login now.");
        } else {
            System.out.println("Error: Mobile number must be 10 digits!");
        }
    }

    public void proceedToLogin() {
        System.out.println("-----Login-----");
        System.out.println("New User? Please Sign Up first before Login!");
        System.out.println("Enter your Mobile Number: ");
        String mobileNo = sc.nextLine();
        System.out.println("Enter your Password: ");
        String password = sc.nextLine();

        if (loginModel.isValidUser(mobileNo, password)) {


            String userName = loginModel.getUserName(mobileNo);
            System.out.println("---Login Successful!---");
            System.out.println("Welcome, " + userName + "!");

            if (mobileNo.equals("9876543210")) {
                System.out.println("Logged in as Admin.");
                TrainManagementView adminView = new TrainManagementView();
                adminView.display();
            } else {
                TrainSearchView searchView = new TrainSearchView();
                searchView.locationSearch();
            }
        } else {
            System.out.println("Invalid Mobile or Password!");
            System.out.println("If you are a New User, Please Sign Up first!");
        }
    }
}