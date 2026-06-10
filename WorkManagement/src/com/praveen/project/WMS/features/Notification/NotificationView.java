package com.praveen.project.WMS.features.Notification;

import com.praveen.project.WMS.data.dto.Employee;
import com.praveen.project.WMS.data.dto.Notification;
import com.praveen.project.WMS.util.AppScanner;
import java.util.List;
import java.util.Scanner;

public class NotificationView {

    private final NotificationModel notificationModel = NotificationModel.getInstance();
    private final Scanner sc = AppScanner.get();

    public void viewNotifications(Employee employee) {
        System.out.println("\n===== Notifications =====");
        System.out.println("1. All Notifications");
        System.out.println("2. Unread Only");
        System.out.println("3. Mark as Read");
        System.out.print("Choose: ");

        String choice = sc.nextLine().trim();
        List<Notification> list;

        switch (choice) {
            case "2":
                list = notificationModel.getUnreadOf(employee.getId()); break;
            case "3":
                System.out.print("Enter Notification ID to mark as read: ");
                try {
                    long nid = Long.parseLong(sc.nextLine().trim());
                    if (notificationModel.markAsRead(nid)) {
                        System.out.println("Marked as read!");
                    } else {
                        System.out.println("Notification not found!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID!");
                }
                return;
            default:
                list = notificationModel.getNotificationsOf(employee.getId());
        }

        if (list.isEmpty()) { System.out.println("No notifications!"); return; }

        System.out.printf("%-5s %-15s %-40s %-10s%n", "ID", "Type", "Message", "Read");
        System.out.println("-".repeat(75));
        for (Notification n : list) {
            System.out.printf("%-5d %-15s %-40s %-10s%n",
                    n.getId(), n.getType(), n.getMessage(), n.isRead() ? "Yes" : "No");
        }
    }
}