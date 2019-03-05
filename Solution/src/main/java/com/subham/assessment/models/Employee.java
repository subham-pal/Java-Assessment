package com.subham.assessment.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private String dateOfJoining;
    private EmployeeType employeeType;
    private EmployeeRole employeeRole;

    private static int currentIdAvailable;

    public static void incrementCurrentIDAvailable(){
        currentIdAvailable++;
    }
    public static int getCurrentIdAvailable(){
        return currentIdAvailable;
    }

}
