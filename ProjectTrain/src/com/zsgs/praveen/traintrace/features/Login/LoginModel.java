package com.zsgs.praveen.traintrace.features.Login;
import com.zsgs.praveen.traintrace.data.dto.User;
import java.util.ArrayList;
import java.util.List;

public class LoginModel {
    private List<User> userList = new ArrayList<>();

    public LoginModel() {
        userList.add(new User("Admin", "Admin@zsgs", "9876543210"));
    }

    public void registration(String name, String password, String mobileNo) {
        userList.add(new User(name, password, mobileNo));
    }

    public boolean isValidUser(String mobile, String password) {
        for (User u : userList) {
            if (u.getUserMobileNo().equals(mobile) && u.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public String getUserName(String mobile) {
        for (User u : userList) {
            if (u.getUserMobileNo().equals(mobile)) {
                return u.getUserName();
            }
        }
        return "User";
    }
}