package com.praveen.project.WMS.features.Login;

import com.praveen.project.WMS.data.dto.Employee;
import com.praveen.project.WMS.features.Employee.EmployeeModel;

public class LoginModel {

    private final EmployeeModel employeeModel = new EmployeeModel();

    public Employee login(String email, String password) {
        for (Employee e : employeeModel.getAllEmployees()) {
            if (e.getEmail().equalsIgnoreCase(email)
                    && e.getPassword().equals(password)
                    && e.getStatus() == Employee.Status.ACTIVE) {
                return e;
            }
        }
        return null;
    }
}