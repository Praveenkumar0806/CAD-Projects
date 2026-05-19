package com.praveen.project.WMS.data.dto;

public class Task {

        public enum Priority { P1, P2, P3 }
        public enum Status { OPEN, INPROGRESS, COMPLETED, ONHOLD, CANCELLED, REOPENED }

        private long id;
        private String title;
        private String description;
        private long assignedBy;
        private long assignedTo;
        private Priority priority;
        private long createdTime;
        private long dueDate;
        private long updatedTime;
        private long completedTime;
        private String remarks;
        private Status status;

        public Task(long id, String title, String description, long assignedBy,
                    long assignedTo, Priority priority, long createdTime,
                    long dueDate, String remarks) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.assignedBy = assignedBy;
            this.assignedTo = assignedTo;
            this.priority = priority;
            this.createdTime = createdTime;
            this.dueDate = dueDate;
            this.updatedTime = createdTime;
            this.completedTime = 0;
            this.remarks = remarks;
            this.status = Status.OPEN;
        }

        public long getId() { return id; }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public long getAssignedBy() { return assignedBy; }
        public long getAssignedTo() { return assignedTo; }
        public Priority getPriority() { return priority; }
        public long getCreatedTime() { return createdTime; }
        public long getDueDate() { return dueDate; }
        public long getUpdatedTime() { return updatedTime; }
        public long getCompletedTime() { return completedTime; }
        public String getRemarks() { return remarks; }
        public Status getStatus() { return status; }

        public void setStatus(Status status) { this.status = status; }
        public void setUpdatedTime(long updatedTime) { this.updatedTime = updatedTime; }
        public void setCompletedTime(long completedTime) { this.completedTime = completedTime; }
        public void setRemarks(String remarks) { this.remarks = remarks; }
        public void setPriority(Priority priority) { this.priority = priority; }
}
