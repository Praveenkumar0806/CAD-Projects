package com.zsgs.praveen.traintrace.data.dto;

public class User {
    private String userName;
    private String userPassword;
    private String userMobileNo;
    private boolean isAdmin;

    public User(String userName, String userPassword, String userMobileNo, boolean isAdmin) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMobileNo = userMobileNo;
        this.isAdmin = isAdmin;
    }

    public String getUserName() { return userName; }
    public String getUserPassword() { return userPassword; }
    public String getUserMobileNo() { return userMobileNo; }
    public boolean isAdmin() { return isAdmin; }
}