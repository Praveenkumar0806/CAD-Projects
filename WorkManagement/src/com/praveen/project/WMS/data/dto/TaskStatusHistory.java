package com.praveen.project.WMS.data.dto;

public class TaskStatusHistory {
    private long id;
    private long taskId;
    private long changedBy;
    private Task.Status oldStatus;
    private Task.Status newStatus;
    private String remarks;
    private long changedTime;

    public TaskStatusHistory(long id, long taskId, long changedBy,
                             Task.Status oldStatus, Task.Status newStatus,
                             String remarks, long changedTime) {
        this.id = id;
        this.taskId = taskId;
        this.changedBy = changedBy;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.remarks = remarks;
        this.changedTime = changedTime;
    }

    public long getId() { return id; }
    public long getTaskId() { return taskId; }
    public long getChangedBy() { return changedBy; }
    public Task.Status getOldStatus() { return oldStatus; }
    public Task.Status getNewStatus() { return newStatus; }
    public String getRemarks() { return remarks; }
    public long getChangedTime() { return changedTime; }
}
