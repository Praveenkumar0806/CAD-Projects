package com.praveen.project.WMS.features.Employee;

import com.praveen.project.WMS.data.dto.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    private static EmployeeModel instance;
    private static final List<Employee> employeeList = new ArrayList<>();
    private static long idCounter = 1;

    static {
        employeeList.add(new Employee(
                idCounter++, "1", "Praveen",
                "Praveen@123.com", "12345",
                "1234567890", 0L,
                Employee.Role.MANAGER, 0L,
                Employee.Status.ACTIVE, System.currentTimeMillis()));
    }

    private EmployeeModel() {}

    public static EmployeeModel getInstance() {
        if (instance == null) instance = new EmployeeModel();
        return instance;
    }

    public boolean addEmployee(Employee employee) {
        for (Employee e : employeeList) {
            if (e.getEmail().equalsIgnoreCase(employee.getEmail())) return false;
        }
        employeeList.add(employee);
        return true;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public List<Employee> getTeamOf(long managerId) {
        List<Employee> team = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getReportingTo() == managerId) team.add(e);
        }
        return team;
    }

    public Employee findById(long id) {
        for (Employee e : employeeList) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public Employee findByEmail(String email) {
        for (Employee e : employeeList) {
            if (e.getEmail().equalsIgnoreCase(email)) return e;
        }
        return null;
    }

    public long getNextId() { return idCounter++; }

    public boolean deactivateEmployee(long id) {
        Employee e = findById(id);
        if (e == null) return false;
        e.setStatus(Employee.Status.INACTIVE);
        return true;
    }
}