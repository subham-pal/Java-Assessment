package com.subham.assessment.services;

import com.subham.assessment.models.Employee;
import com.subham.assessment.models.EmployeeRole;
import com.subham.assessment.models.EmployeeType;
import com.subham.assessment.utils.ValidityChecker;

public class EmployeeCreator {
    public Employee createEmployee(String name, String email, String dateOfJoining, EmployeeType employeeType, EmployeeRole
                             employeeRole){
        ValidityChecker validityChecker = new ValidityChecker();
        if(!validityChecker.isEmailValid(email) || !validityChecker.isNameValid(name)){
            return null;
        }
        Employee.incrementCurrentIDAvailable();

        Employee employee = new Employee(Employee.getCurrentIdAvailable(), name, email, dateOfJoining, employeeType,employeeRole);
        return employee;
    }
}
