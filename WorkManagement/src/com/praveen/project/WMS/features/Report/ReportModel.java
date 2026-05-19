package com.praveen.project.WMS.features.Report;

import com.praveen.project.WMS.data.dto.Employee;
import com.praveen.project.WMS.data.dto.Task;
import com.praveen.project.WMS.features.Employee.EmployeeModel;
import com.praveen.project.WMS.features.Task.TaskModel;
import java.util.List;

public class ReportModel {

    private final TaskModel taskModel = new TaskModel();
    private final EmployeeModel employeeModel = new EmployeeModel();

    public void printEmployeeReport(long employeeId) {
        Employee emp = employeeModel.findById(employeeId);
        if (emp == null) { System.out.println("Employee not found!"); return; }

        List<Task> tasks = taskModel.getTasksOf(employeeId);

        long total     = tasks.size();
        long open      = tasks.stream().filter(t -> t.getStatus() == Task.Status.OPEN).count();
        long inprog    = tasks.stream().filter(t -> t.getStatus() == Task.Status.INPROGRESS).count();
        long completed = tasks.stream().filter(t -> t.getStatus() == Task.Status.COMPLETED).count();
        long onhold    = tasks.stream().filter(t -> t.getStatus() == Task.Status.ONHOLD).count();
        long cancelled = tasks.stream().filter(t -> t.getStatus() == Task.Status.CANCELLED).count();
        long reopened  = tasks.stream().filter(t -> t.getStatus() == Task.Status.REOPENED).count();

        System.out.println("\n========== Employee Report ==========");
        System.out.println("  Name       : " + emp.getName());
        System.out.println("  Employee ID: " + emp.getEmployeeId());
        System.out.println("  Role       : " + emp.getRole());
        System.out.println("  Status     : " + emp.getStatus());
        System.out.println("-------------------------------------");
        System.out.println("  Total Tasks   : " + total);
        System.out.println("  Open          : " + open);
        System.out.println("  In Progress   : " + inprog);
        System.out.println("  Completed     : " + completed);
        System.out.println("  On Hold       : " + onhold);
        System.out.println("  Cancelled     : " + cancelled);
        System.out.println("  Reopened      : " + reopened);
        System.out.println("=====================================");
    }

    public void printTeamReport(long managerId) {
        List<Employee> team = employeeModel.getTeamOf(managerId);
        if (team.isEmpty()) { System.out.println("No team members found!"); return; }

        System.out.println("\n========== Team Report ==========");
        System.out.printf("%-5s %-20s %-8s %-10s %-8s %-8s %-8s%n",
                "ID", "Name", "Total", "Completed", "InProg", "Open", "OnHold");
        System.out.println("-".repeat(75));

        for (Employee e : team) {
            List<Task> tasks = taskModel.getTasksOf(e.getId());
            long total     = tasks.size();
            long completed = tasks.stream().filter(t -> t.getStatus() == Task.Status.COMPLETED).count();
            long inprog    = tasks.stream().filter(t -> t.getStatus() == Task.Status.INPROGRESS).count();
            long open      = tasks.stream().filter(t -> t.getStatus() == Task.Status.OPEN).count();
            long onhold    = tasks.stream().filter(t -> t.getStatus() == Task.Status.ONHOLD).count();

            System.out.printf("%-5d %-20s %-8d %-10d %-8d %-8d %-8d%n",
                    e.getId(), e.getName(), total, completed, inprog, open, onhold);
        }
        System.out.println("=================================");
    }

    public void printPriorityReport(long managerId) {
        List<Employee> team = employeeModel.getTeamOf(managerId);

        long p1 = 0, p2 = 0, p3 = 0;
        for (Employee e : team) {
            List<Task> tasks = taskModel.getTasksOf(e.getId());
            p1 += tasks.stream().filter(t -> t.getPriority() == Task.Priority.P1).count();
            p2 += tasks.stream().filter(t -> t.getPriority() == Task.Priority.P2).count();
            p3 += tasks.stream().filter(t -> t.getPriority() == Task.Priority.P3).count();
        }

        System.out.println("\n===== Priority Report =====");
        System.out.println("  P1 (High)   : " + p1);
        System.out.println("  P2 (Medium) : " + p2);
        System.out.println("  P3 (Low)    : " + p3);
        System.out.println("===========================");
    }
}