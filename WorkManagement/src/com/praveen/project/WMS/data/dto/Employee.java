package com.praveen.project.WMS.data.dto;

public class Employee {

    public enum Role { MANAGER, EMPLOYEE }
    public enum Status { ACTIVE, INACTIVE }

    private long id;
    private String employeeId;
    private String name;
    private String email;
    private String password;
    private String mobileNo;
    private long dob;
    private Role role;
    private long reportingTo;
    private Status status;
    private long createdAt;

    public Employee(long id, String employeeId, String name, String email,
                    String password, String mobileNo, long dob,
                    Role role, long reportingTo, Status status, long createdAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.dob = dob;
        this.role = role;
        this.reportingTo = reportingTo;
        this.status = status;
        this.createdAt = createdAt;
    }

    public long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getMobileNo() { return mobileNo; }
    public long getDob() { return dob; }
    public Role getRole() { return role; }
    public long getReportingTo() { return reportingTo; }
    public Status getStatus() { return status; }
    public long getCreatedAt() { return createdAt; }

    public void setStatus(Status status) { this.status = status; }
    public void setPassword(String password) { this.password = password; }
    public void setReportingTo(long reportingTo) { this.reportingTo = reportingTo; }
}