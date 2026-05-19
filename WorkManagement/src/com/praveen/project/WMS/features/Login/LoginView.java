package com.praveen.project.WMS.features.Login;

import com.praveen.project.WMS.data.dto.Employee;
import com.praveen.project.WMS.features.Employee.EmployeeView;
import com.praveen.project.WMS.features.Task.TaskView;
import com.praveen.project.WMS.features.Notification.NotificationView;
import com.praveen.project.WMS.util.AppScanner;
import java.util.Scanner;

public class LoginView {

    private final LoginModel loginModel = new LoginModel();
    private final Scanner sc = AppScanner.get();

    public void init() {
        while (true) {
            System.out.println("\n===== Welcome to 'WMS' - Work Management System =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": proceedToLogin(); break;
                case "2":
                    System.out.println("Thank you for using ThiranX. Bye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void proceedToLogin() {
        System.out.println("\n----- Login -----");
        System.out.print("Enter Email    : ");
        String email = sc.nextLine().trim();
        System.out.print("Enter Password : ");
        String password = sc.nextLine().trim();

        Employee emp = loginModel.login(email, password);
        if (emp == null) {
            System.out.println("Invalid Email or Password!");
            return;
        }

        System.out.println("\nWelcome, " + emp.getName() + "! [" + emp.getRole() + "]");

        if (emp.getRole() == Employee.Role.MANAGER) {
            showManagerMenu(emp);
        } else {
            showEmployeeMenu(emp);
        }
    }

    private void showManagerMenu(Employee manager) {
        EmployeeView employeeView = new EmployeeView();
        TaskView taskView = new TaskView();

        while (true) {
            System.out.println("\n===== Manager Menu =====");
            System.out.println("1. Create Employee Account");
            System.out.println("2. View All Employees");
            System.out.println("3. Assign Task");
            System.out.println("4. View Team Task Status");
            System.out.println("5. View Employee Report");
            System.out.println("6. Logout");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": employeeView.createEmployee(); break;
                case "2": employeeView.viewAllEmployees(); break;
                case "3": taskView.assignTask(manager); break;
                case "4": taskView.viewTeamTaskStatus(manager); break;
                case "5": taskView.viewEmployeeReport(manager); break;
                case "6": System.out.println("Logged out!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void showEmployeeMenu(Employee employee) {
        TaskView taskView = new TaskView();
        NotificationView notificationView = new NotificationView();

        while (true) {
            System.out.println("\n===== Employee Menu =====");
            System.out.println("1. View My Tasks");
            System.out.println("2. Update Task Status");
            System.out.println("3. View Notifications");
            System.out.println("4. Logout");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": taskView.viewMyTasks(employee); break;
                case "2": taskView.updateTaskStatus(employee); break;
                case "3": notificationView.viewNotifications(employee); break;
                case "4": System.out.println("Logged out!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}