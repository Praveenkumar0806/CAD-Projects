package com.praveen.project.WMS.features.Task;

import com.praveen.project.WMS.data.dto.Employee;
import com.praveen.project.WMS.data.dto.Task;
import com.praveen.project.WMS.features.Employee.EmployeeModel;
import com.praveen.project.WMS.features.Notification.NotificationModel;
import com.praveen.project.WMS.util.AppScanner;
import com.praveen.project.WMS.data.dto.Notification;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskView {

    private final TaskModel taskModel = new TaskModel();
    private final EmployeeModel employeeModel = new EmployeeModel();
    private final NotificationModel notificationModel = new NotificationModel();
    private final Scanner sc = AppScanner.get();

    public void assignTask(Employee manager) {
        System.out.println("\n----- Assign Task -----");

        List<Employee> team = employeeModel.getTeamOf(manager.getId());
        if (team.isEmpty()) {
            System.out.println("No team members found!");
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

        System.out.print("Task Title       : ");
        String title = sc.nextLine().trim();
        System.out.print("Description      : ");
        String desc = sc.nextLine().trim();
        System.out.print("Priority (P1/P2/P3): ");
        Task.Priority priority;
        try {
            priority = Task.Priority.valueOf(sc.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Priority! Use P1, P2, or P3");
            return;
        }
        System.out.print("Due Date (epoch ms): ");
        long dueDate;
        try {
            dueDate = Long.parseLong(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid date!");
            return;
        }

        long id = taskModel.getNextId();
        Task task = new Task(id, title, desc, manager.getId(),
                assignTo, priority, System.currentTimeMillis(), dueDate, "");

        taskModel.addTask(task);

        // ✅ Fixed - correct package use pannrom
        notificationModel.addNotification(assignTo, id,
                "New task assigned: " + title, Notification.Type.TASK_ASSIGNED);

        System.out.println("Task '" + title + "' assigned successfully! [Task ID: " + id + "]");
    }

    public void viewMyTasks(Employee employee) {
        System.out.println("\n===== My Tasks =====");
        System.out.println("1. All Tasks");
        System.out.println("2. Todo (Open)");
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
                    taskModel.findById(taskId).getAssignedBy(), taskId,
                    "Task status updated to " + newStatus,
                    Notification.Type.STATUS_UPDATED);
            System.out.println("Status updated successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    public void viewTeamTaskStatus(Employee manager) {
        System.out.println("\n===== Team Task Status =====");
        List<Employee> team = employeeModel.getTeamOf(manager.getId());
        List<Long> ids = new ArrayList<>();
        for (Employee e : team) ids.add(e.getId());

        List<Task> tasks = taskModel.getTeamTasks(ids);
        if (tasks.isEmpty()) { System.out.println("No tasks found for your team!"); return; }

        printTaskTable(tasks);
    }

    public void viewEmployeeReport(Employee manager) {
        System.out.println("\n===== Employee Report =====");
        List<Employee> team = employeeModel.getTeamOf(manager.getId());
        for (Employee e : team) {
            List<Task> tasks = taskModel.getTasksOf(e.getId());
            long completed = tasks.stream().filter(t -> t.getStatus() == Task.Status.COMPLETED).count();
            long inprogress = tasks.stream().filter(t -> t.getStatus() == Task.Status.INPROGRESS).count();
            long open = tasks.stream().filter(t -> t.getStatus() == Task.Status.OPEN).count();

            System.out.println("\n  Employee : " + e.getName() + " [" + e.getEmployeeId() + "]");
            System.out.println("  Total    : " + tasks.size()
                    + " | Completed: " + completed
                    + " | InProgress: " + inprogress
                    + " | Open: " + open);
        }
    }

    private void printTaskTable(List<Task> tasks) {
        if (tasks.isEmpty()) { System.out.println("No tasks found!"); return; }
        System.out.printf("%n%-5s %-25s %-10s %-12s %-10s%n",
                "ID", "Title", "Priority", "Status", "Due");
        System.out.println("-".repeat(65));
        for (Task t : tasks) {
            System.out.printf("%-5d %-25s %-10s %-12s %-10d%n",
                    t.getId(), t.getTitle(), t.getPriority(),
                    t.getStatus(), t.getDueDate());
        }
    }
}