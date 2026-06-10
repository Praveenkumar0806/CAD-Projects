package com.praveen.project.WMS.features.Notification;

import com.praveen.project.WMS.data.dto.Notification;
import java.util.ArrayList;
import java.util.List;

public class NotificationModel {

    private static NotificationModel instance;
    private static final List<Notification> notificationList = new ArrayList<>();
    private static long idCounter = 1;

    private NotificationModel() {}

    public static NotificationModel getInstance() {
        if (instance == null) instance = new NotificationModel();
        return instance;
    }

    public void addNotification(long employeeId, long taskId,
                                String message, Notification.Type type) {
        notificationList.add(new Notification(
                idCounter++, employeeId, taskId,
                message, type, System.currentTimeMillis()));
    }

    public List<Notification> getNotificationsOf(long employeeId) {
        List<Notification> result = new ArrayList<>();
        for (Notification n : notificationList) {
            if (n.getEmployeeId() == employeeId) result.add(n);
        }
        return result;
    }

    public List<Notification> getUnreadOf(long employeeId) {
        List<Notification> result = new ArrayList<>();
        for (Notification n : notificationList) {
            if (n.getEmployeeId() == employeeId && !n.isRead()) result.add(n);
        }
        return result;
    }

    public boolean markAsRead(long notificationId) {
        for (Notification n : notificationList) {
            if (n.getId() == notificationId) {
                n.markAsRead();
                return true;
            }
        }
        return false;
    }
}