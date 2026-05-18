package com.project.SMS;

public class Admin extends  User{

    public Admin(String name)
    {
        super(name);
    }
    public void showMenu()
    {
        System.out.println("Welcome Admin "+userName);
        System.out.println("1.Add student ");
        System.out.println("2.View All Student ");
        System.out.println("3.Update Student Mark ");
        System.out.println("4.Exit ");
    }
}
