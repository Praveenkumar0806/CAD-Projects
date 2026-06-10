package com.praveen.project.WMS.data.dto;

public class Notification {
    public enum Type { TASK_ASSIGNED, STATUS_UPDATED, DUE_REMINDER }

    private long id;
    private long employeeId;
    private long taskId;
    private String message;
    private Type type;
    private boolean isRead;
    private long createdTime;

    public Notification(long id, long employeeId, long taskId,
                        String message, Type type, long createdTime) {
        this.id = id;
        this.employeeId = employeeId;
        this.taskId = taskId;
        this.message = message;
        this.type = type;
        this.isRead = false;
        this.createdTime = createdTime;
    }

    public long getId() { return id; }
    public long getEmployeeId() { return employeeId; }
    public long getTaskId() { return taskId; }
    public String getMessage() { return message; }
    public Type getType() { return type; }
    public boolean isRead() { return isRead; }
    public long getCreatedTime() { return createdTime; }

    public void markAsRead() { this.isRead = true; }
}
