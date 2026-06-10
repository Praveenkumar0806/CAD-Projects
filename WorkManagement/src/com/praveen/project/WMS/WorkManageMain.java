package com.praveen.project.WMS;

import com.praveen.project.WMS.features.Login.LoginView;

public class WorkManageMain {
    //Hard code (Duplicate Login)
    //e-mail:Praveen@123.com,pass:12345.
    public static void main(String[] args) {
        new LoginView().init();
    }
}