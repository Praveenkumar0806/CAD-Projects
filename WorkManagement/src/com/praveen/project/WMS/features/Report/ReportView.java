package com.praveen.project.WMS.features.Report;

import com.praveen.project.WMS.data.dto.Employee;
import com.praveen.project.WMS.features.Employee.EmployeeModel;
import com.praveen.project.WMS.util.AppScanner;
import java.util.Scanner;

public class ReportView {

    private final ReportModel reportModel = new ReportModel();
    private final EmployeeModel employeeModel = EmployeeModel.getInstance();
    private final Scanner sc = AppScanner.get();

    public void showReportMenu(Employee manager) {
        while (true) {
            System.out.println("\n===== Report Management =====");
            System.out.println("1. Individual Employee Report");
            System.out.println("2. Full Team Report");
            System.out.println("3. Priority-wise Report");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": individualReport(manager); break;
                case "2": reportModel.printTeamReport(manager.getId()); break;
                case "3": reportModel.printPriorityReport(manager.getId()); break;
                case "4": return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void individualReport(Employee manager) {
        System.out.println("\nYour Team:");
        for (Employee e : employeeModel.getTeamOf(manager.getId())) {
            System.out.println("  [" + e.getId() + "] " + e.getName());
        }
        System.out.print("Enter Employee ID: ");
        try {
            long empId = Long.parseLong(sc.nextLine().trim());
            reportModel.printEmployeeReport(empId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID!");
        }
    }
}