package com.subham.assessment.services;

import com.subham.assessment.models.*;
import com.subham.assessment.utils.ValidityChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeCreator {
    public Employee createEmployee(String name, String email, String dateOfJoining, EmployeeType employeeType, EmployeeRole
                             employeeRole){
        ValidityChecker validityChecker = new ValidityChecker();
        if(!validityChecker.isEmailValid(email) || !validityChecker.isNameValid(name)){
            return null;
        }
        Employee.incrementCurrentIDAvailable();
        Map<Category, Integer> leave = new HashMap<Category, Integer>();
        leave.put(new Category(EmployeeType.PROBATION, null), 0);
        leave.put(new Category(EmployeeType.PROBATION, LeaveType.SICKLEAVE), 0);
        leave.put(new Category(EmployeeType.PROBATION, LeaveType.CASUALLEAVE), 0);
        leave.put(new Category(EmployeeType.PROBATION, LeaveType.PRIVILEGELEAVE), 0);
        leave.put(new Category(EmployeeType.PERMANENT, LeaveType.SICKLEAVE), 5);
        leave.put(new Category(EmployeeType.PERMANENT, LeaveType.CASUALLEAVE), 5);
        leave.put(new Category(EmployeeType.PERMANENT, LeaveType.PRIVILEGELEAVE), 15);
        Employee employee = new Employee(Employee.getCurrentIdAvailable(), name, email, dateOfJoining, employeeType,employeeRole, leave);
        return employee;
    }
}
