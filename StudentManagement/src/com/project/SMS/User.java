package com.project.SMS;

abstract class User {
     String userName;

    public User(String userName)
    {
        this.userName=userName;
    }

    abstract void showMenu();
}
