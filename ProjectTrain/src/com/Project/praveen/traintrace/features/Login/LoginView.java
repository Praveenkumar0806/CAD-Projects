package com.Project.praveen.traintrace.features.Login;

import com.Project.praveen.traintrace.data.dto.User;
import com.Project.praveen.traintrace.features.trainmanagement.TrainManagementView;
import com.Project.praveen.traintrace.features.trainsearch.TrainSearchView;
import com.Project.praveen.traintrace.util.AppScanner;
import java.util.Scanner;

public class LoginView {
    private final LoginModel loginModel = new LoginModel();
    private final Scanner sc = AppScanner.get();

    public void init() {
        while (true) {
            System.out.println("\n===== Welcome to Train Tracking System =====");
            System.out.println("1. Login");
            System.out.println("2. Sign Up (New User)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();
            switch (input) {
                case "1": proceedToLogin(); break;
                case "2": proceedToSignUp(); break;
                case "3":
                    System.out.println("Thank you for using TrainTrace. Bye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }

    private void proceedToSignUp() {
        System.out.println("\n----- New User Registration -----");
        System.out.print("Enter your Name     : ");
        String name = sc.nextLine().trim();
        System.out.print("Enter your Password : ");
        String password = sc.nextLine().trim();
        System.out.print("Enter Mobile Number : ");
        String mobile = sc.nextLine().trim();

        if (mobile.length() != 10) {
            System.out.println("Error: Mobile number must be 10 digits!");
        } else if (loginModel.register(name, password, mobile)) {
            System.out.println("Registration Successful! You can login now.");
        } else {
            System.out.println("Error: Mobile number already registered!");
        }
    }

    private void proceedToLogin() {
        System.out.println("\n----- Login -----");
        System.out.print("Enter Mobile Number : ");
        String mobile = sc.nextLine().trim();
        System.out.print("Enter Password      : ");
        String password = sc.nextLine().trim();

        User user = loginModel.getValidUser(mobile, password);
        if (user != null) {
            System.out.println("\n--- Login Successful! ---");
            System.out.println("Welcome, " + user.getUserName() + "!");
            if (user.isAdmin()) {
                System.out.println("Logged in as Admin.");
                new TrainManagementView().display();
            } else {
                new TrainSearchView().locationSearch();
            }
        } else {
            System.out.println("Invalid Mobile or Password!");
            System.out.println("New User? Please Sign Up first!");
        }
    }
}