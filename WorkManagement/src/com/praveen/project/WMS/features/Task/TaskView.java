package com.praveen.project.WMS.features.Task;

import com.praveen.project.WMS.data.dto.Employee;
import com.praveen.project.WMS.data.dto.Notification;
import com.praveen.project.WMS.data.dto.Task;
import com.praveen.project.WMS.features.Employee.EmployeeModel;
import com.praveen.project.WMS.features.Notification.NotificationModel;
import com.praveen.project.WMS.util.AppScanner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskView {

    private final TaskModel taskModel = TaskModel.getInstance();
    private final EmployeeModel employeeModel = EmployeeModel.getInstance();
    private final NotificationModel notificationModel = NotificationModel.getInstance();
    private final Scanner sc = AppScanner.get();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public void assignTask(Employee manager) {
        System.out.println("\n----- Assign Task -----");

        List<Employee> team = employeeModel.getTeamOf(manager.getId());
        if (team.isEmpty()) {
            System.out.println("You don't have any team members yet!");
            System.out.println("Please create employee accounts first.");
            return;
        }

        System.out.println("Your Team:");
        for (Employee e : team) {
            System.out.println("  [" + e.getId() + "] " + e.getName());
        }

        System.out.print("Assign To (Employee ID): ");
        long assignTo;
        try {
            assignTo = Long.parseLong(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID!");
            return;
        }

        // Employee team-la irukkaanga-aa check
        Employee assignee = employeeModel.findById(assignTo);
        if (assignee == null || assignee.getReportingTo() != manager.getId()) {
            System.out.println("Invalid Employee ID! Choose from your team only.");
            return;
        }

        System.out.print("Task Title         : ");
        String title = sc.nextLine().trim();
        System.out.print("Description        : ");
        String desc = sc.nextLine().trim();
        System.out.print("Priority (P1/P2/P3): ");
        Task.Priority priority;
        try {
            priority = Task.Priority.valueOf(sc.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Priority! Use P1, P2, or P3");
            return;
        }

        System.out.println("\nSelect Due Date:");
        System.out.println("  1. Tomorrow");
        System.out.println("  2. 1 Week Later");
        System.out.println("  3. 1 Month Later");
        System.out.print("Choose option: ");

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        String dateChoice = sc.nextLine().trim();
        switch (dateChoice) {
            case "1": calendar.add(java.util.Calendar.DAY_OF_YEAR, 1); break;
            case "2": calendar.add(java.util.Calendar.WEEK_OF_YEAR, 1); break;
            case "3": calendar.add(java.util.Calendar.MONTH, 1); break;
            default:
                System.out.println("Invalid choice! Setting to Tomorrow by default.");
                calendar.add(java.util.Calendar.DAY_OF_YEAR, 1);
                break;
        }
        long dueDate = calendar.getTimeInMillis();

        long id = taskModel.getNextId();
        Task task = new Task(id, title, desc, manager.getId(),
                assignTo, priority, System.currentTimeMillis(), dueDate, "");

        taskModel.addTask(task);

        notificationModel.addNotification(assignTo, id,
                "New task assigned: " + title, Notification.Type.TASK_ASSIGNED);

        System.out.println("Task '" + title + "' assigned! [Task ID: " + id + "] Due: "
                + sdf.format(new Date(dueDate)));
    }

    public void viewMyTasks(Employee employee) {
        System.out.println("\n===== My Tasks =====");
        System.out.println("1. All Tasks");
        System.out.println("2. Open");
        System.out.println("3. In Progress");
        System.out.println("4. Completed");
        System.out.print("Choose: ");

        String choice = sc.nextLine().trim();
        List<Task> tasks;
        switch (choice) {
            case "2": tasks = taskModel.getTasksByStatus(employee.getId(), Task.Status.OPEN); break;
            case "3": tasks = taskModel.getTasksByStatus(employee.getId(), Task.Status.INPROGRESS); break;
            case "4": tasks = taskModel.getTasksByStatus(employee.getId(), Task.Status.COMPLETED); break;
            default:  tasks = taskModel.getTasksOf(employee.getId()); break;
        }
        printTaskTable(tasks);
    }

    public void updateTaskStatus(Employee employee) {
        System.out.println("\n----- Update Task Status -----");
        List<Task> tasks = taskModel.getTasksOf(employee.getId());
        if (tasks.isEmpty()) { System.out.println("No tasks found!"); return; }

        printTaskTable(tasks);
        System.out.print("Enter Task ID to update: ");
        long taskId;
        try {
            taskId = Long.parseLong(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID!");
            return;
        }

        // Task ownership check
        Task taskToUpdate = taskModel.findById(taskId);
        if (taskToUpdate == null) { System.out.println("Task not found!"); return; }
        if (taskToUpdate.getAssignedTo() != employee.getId()) {
            System.out.println("Access Denied! You can only update your own tasks.");
            return;
        }

        System.out.println("Status Options: OPEN / INPROGRESS / COMPLETED / ONHOLD / CANCELLED / REOPENED");
        System.out.print("New Status: ");
        Task.Status newStatus;
        try {
            newStatus = Task.Status.valueOf(sc.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status!");
            return;
        }

        System.out.print("Remarks: ");
        String remarks = sc.nextLine().trim();

        if (taskModel.updateStatus(taskId, employee.getId(), newStatus, remarks)) {
            notificationModel.addNotification(
                    taskToUpdate.getAssignedBy(), taskId,
                    "Task '" + taskToUpdate.getTitle() + "' status updated to " + newStatus,
                    Notification.Type.STATUS_UPDATED);
            System.out.println("Status updated successfully!");
        } else {
            System.out.println("Update failed!");
        }
    }

    public void viewTeamTaskStatus(Employee manager) {
        System.out.println("\n===== Team Task Status =====");
        List<Employee> team = employeeModel.getTeamOf(manager.getId());
        if (team.isEmpty()) { System.out.println("No team members found!"); return; }

        List<Long> ids = new ArrayList<>();
        for (Employee e : team) ids.add(e.getId());

        List<Task> tasks = taskModel.getTeamTasks(ids);
        if (tasks.isEmpty()) { System.out.println("No tasks assigned to your team yet!"); return; }

        printTaskTable(tasks);
    }

    public void viewEmployeeReport(Employee manager) {
        System.out.println("\n===== Employee Report =====");
        List<Employee> team = employeeModel.getTeamOf(manager.getId());
        if (team.isEmpty()) { System.out.println("No team members found!"); return; }

        for (Employee e : team) {
            List<Task> tasks = taskModel.getTasksOf(e.getId());
            long completed  = tasks.stream().filter(t -> t.getStatus() == Task.Status.COMPLETED).count();
            long inprogress = tasks.stream().filter(t -> t.getStatus() == Task.Status.INPROGRESS).count();
            long open       = tasks.stream().filter(t -> t.getStatus() == Task.Status.OPEN).count();

            System.out.println("\n  Employee   : " + e.getName() + " [" + e.getEmployeeId() + "]");
            System.out.println("  Total      : " + tasks.size()
                    + " | Completed: " + completed
                    + " | InProgress: " + inprogress
                    + " | Open: " + open);
        }
    }

    private void printTaskTable(List<Task> tasks) {
        if (tasks.isEmpty()) { System.out.println("No tasks found!"); return; }
        System.out.printf("%n%-5s %-25s %-10s %-12s %-12s%n",
                "ID", "Title", "Priority", "Status", "Due Date");
        System.out.println("-".repeat(68));
        for (Task t : tasks) {
            String dueDate = sdf.format(new Date(t.getDueDate()));
            System.out.printf("%-5d %-25s %-10s %-12s %-12s%n",
                    t.getId(), t.getTitle(), t.getPriority(),
                    t.getStatus(), dueDate);
        }
    }
}