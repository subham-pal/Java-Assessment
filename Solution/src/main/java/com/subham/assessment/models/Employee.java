package com.subham.assessment.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;


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
    private Map<Category, Integer> leaves;

    public static Holidays holidays;

    private static int currentIdAvailable;

    public static void incrementCurrentIDAvailable(){
        currentIdAvailable++;
    }
    public static int getCurrentIdAvailable(){
        return currentIdAvailable;
    }
    public int getleave(LeaveType leaveType){
        Category category = new Category(employeeType, leaveType);
        return leaves.get(category);
    }

    public void viewHolidays(){
        holidays.view();
    }

    public static Holidays getHolidays(){
        return holidays;
    }

}
