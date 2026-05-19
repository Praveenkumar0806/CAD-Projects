package com.praveen.project.WMS.features.Employee;

import com.praveen.project.WMS.data.dto.Employee;
import com.praveen.project.WMS.util.AppScanner;
import java.util.List;
import java.util.Scanner;

public class EmployeeView {

    private final EmployeeModel employeeModel = new EmployeeModel();
    private final Scanner sc = AppScanner.get();

    public void createEmployee() {
        System.out.println("\n----- Create Employee Account -----");
        System.out.print("Name        : ");
        String name = sc.nextLine().trim();
        System.out.print("Email       : ");
        String email = sc.nextLine().trim();
        System.out.print("Password    : ");
        String password = sc.nextLine().trim();
        System.out.print("Mobile No   : ");
        String mobile = sc.nextLine().trim();
        System.out.print("Employee ID : ");
        String empId = sc.nextLine().trim();
        System.out.print("Reporting To (Manager ID): ");
        long reportingTo;
        try {
            reportingTo = Long.parseLong(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Manager ID!");
            return;
        }

        long id = employeeModel.getNextId();
        Employee newEmp = new Employee(id, empId, name, email, password,
                mobile, 0L, Employee.Role.EMPLOYEE,
                reportingTo, Employee.Status.ACTIVE,
                System.currentTimeMillis());

        if (employeeModel.addEmployee(newEmp)) {
            System.out.println("Employee '" + name + "' created successfully! [ID: " + id + "]");
        } else {
            System.out.println("Error: Email already registered!");
        }
    }

    public void viewAllEmployees() {
        System.out.println("\n===== All Employees =====");
        System.out.printf("%-5s %-10s %-20s %-25s %-10s %-10s%n",
                "ID", "EmpID", "Name", "Email", "Role", "Status");
        System.out.println("-".repeat(85));
        for (Employee e : employeeModel.getAllEmployees()) {
            System.out.printf("%-5d %-10s %-20s %-25s %-10s %-10s%n",
                    e.getId(), e.getEmployeeId(), e.getName(),
                    e.getEmail(), e.getRole(), e.getStatus());
        }
    }
}