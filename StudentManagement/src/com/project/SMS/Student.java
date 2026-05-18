package com.project.SMS;

public class Student {
    private int rollNo;
    private String name;
    private String mailId;
    private String department;
    private String gender;
    private String city;
    private String phoneNumber;
    private int mark;


    public Student(int rollNo, String name, String mailId,
                   String department, String gender, String city,
                   String phoneNumber, int mark) {
        this.rollNo = rollNo;
        this.name = name;
        this.mailId = mailId;
        this.department = department;
        this.gender = gender;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.mark=mark;
    }


    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getMailId() { return mailId; }
    public String getDepartment() { return department; }
    public String getGender() { return gender; }
    public String getCity() { return city; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getMark(){return mark;}



    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
    public void setName(String name) { this.name = name; }
    public void setMailId(String mailId) { this.mailId = mailId; }
    public void setDepartment(String department) { this.department = department; }
    public void setGender(String gender) { this.gender = gender; }
    public void setCity(String city) { this.city = city; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setMark(int mark){this.mark=mark;}

    public void display(){
        System.out.println("Student Roll NO  : "+rollNo+"\n"+
                           "Student Name     : "+name+"\n"+
                           "Student Mail ID  : "+mailId+"\n"+
                           "Student DEPT     : "+department+"\n"+
                           "Student Gender   : "+gender+"\n"+
                           "Student City     : "+city+"\n"+
                           "Student Phone_No : "+phoneNumber+"\n"+
                           "Student Mark     : "+mark);
        System.out.println("=========================================");
    }
}
