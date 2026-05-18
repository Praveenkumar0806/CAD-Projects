package com.zsgs.praveen.traintrace.features.login;

import com.zsgs.praveen.traintrace.data.dto.User;
import java.util.ArrayList;
import java.util.List;

public class LoginModel {
    private List<User> userList = new ArrayList<>();

    public LoginModel() {
        userList.add(new User("Admin", "Admin@zsgs", "9876543210", true));
    }

    public boolean register(String name, String password, String mobileNo) {
        for (User u : userList) {
            if (u.getUserMobileNo().equals(mobileNo)) return false;
        }
        userList.add(new User(name, password, mobileNo, false));
        return true;
    }

    public User getValidUser(String mobile, String password) {
        for (User u : userList) {
            if (u.getUserMobileNo().equals(mobile) && u.getUserPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}