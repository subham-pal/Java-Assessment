package com.subham.assessment.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeList {
    ArrayList<Employee> employees;

    public void add(Employee employee){
        employees.add(employee);
    }

    public void remove(Employee employee){
        employees.remove(employee);
    }
    public Employee getEmployee(Integer id){
        for(int i = 0; i < employees.size(); ++i){
            if(employees.get(i).getId().equals(id)){
                return employees.get(i);
            }
        }
        return null;
    }
}
