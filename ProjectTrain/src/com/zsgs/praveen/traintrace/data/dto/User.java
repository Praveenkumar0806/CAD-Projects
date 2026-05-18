package com.zsgs.praveen.traintrace.data.dto;

public class User {
    private String userName;
    private String userPassword;
    private String userMobileNo;

    public User(String userName,String userPassword,String userMobileNo)
    {
        this.userName=userName;
        this.userPassword=userPassword;
        this.userMobileNo=userMobileNo;
    }

    public String getUserName()
    {
        return userName;
    }
    public  String getUserPassword()
    {
        return userPassword;
    }
    public String getUserMobileNo() {
        return userMobileNo;
    }
}
