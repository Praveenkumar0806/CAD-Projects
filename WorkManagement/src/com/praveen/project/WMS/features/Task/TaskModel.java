package com.praveen.project.WMS.features.Task;

import com.praveen.project.WMS.data.dto.Task;
import com.praveen.project.WMS.data.dto.TaskStatusHistory;
import java.util.ArrayList;
import java.util.List;

public class TaskModel {

    private static final List<Task> taskList = new ArrayList<>();
    private static final List<TaskStatusHistory> historyList = new ArrayList<>();
    private static long taskIdCounter = 1;
    private static long historyIdCounter = 1;

    public boolean addTask(Task task) {
        taskList.add(task);
        return true;
    }

    public List<Task> getTasksOf(long employeeId) {
        List<Task> result = new ArrayList<>();
        for (Task t : taskList) {
            if (t.getAssignedTo() == employeeId) result.add(t);
        }
        return result;
    }

    public List<Task> getTasksByStatus(long employeeId, Task.Status status) {
        List<Task> result = new ArrayList<>();
        for (Task t : taskList) {
            if (t.getAssignedTo() == employeeId && t.getStatus() == status) result.add(t);
        }
        return result;
    }

    public List<Task> getTeamTasks(List<Long> employeeIds) {
        List<Task> result = new ArrayList<>();
        for (Task t : taskList) {
            if (employeeIds.contains(t.getAssignedTo())) result.add(t);
        }
        return result;
    }

    public Task findById(long id) {
        for (Task t : taskList) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public boolean updateStatus(long taskId, long changedBy,
                                Task.Status newStatus, String remarks) {
        Task t = findById(taskId);
        if (t == null) return false;

        Task.Status oldStatus = t.getStatus();
        t.setStatus(newStatus);
        t.setRemarks(remarks);
        t.setUpdatedTime(System.currentTimeMillis());
        if (newStatus == Task.Status.COMPLETED) {
            t.setCompletedTime(System.currentTimeMillis());
        }

        historyList.add(new TaskStatusHistory(
                historyIdCounter++, taskId, changedBy,
                oldStatus, newStatus, remarks, System.currentTimeMillis()));
        return true;
    }

    public List<TaskStatusHistory> getHistoryOf(long taskId) {
        List<TaskStatusHistory> result = new ArrayList<>();
        for (TaskStatusHistory h : historyList) {
            if (h.getTaskId() == taskId) result.add(h);
        }
        return result;
    }

    public long getNextId() { return taskIdCounter++; }

    public List<Task> getAllTasks() { return taskList; }
}