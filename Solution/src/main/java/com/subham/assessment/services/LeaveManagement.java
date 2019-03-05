package com.subham.assessment.services;

import com.subham.assessment.models.Category;
import com.subham.assessment.models.EmployeeList;
import com.subham.assessment.models.EmployeeType;
import com.subham.assessment.models.LeaveType;
import com.subham.assessment.utils.DateUtils;

public class LeaveManagement {
    public boolean applyLeave(EmployeeList employeeList, Integer employeeId, String startDate, String endDate, LeaveType leaveType){
        DateUtils dateUtils = new DateUtils();
        int daysCount = dateUtils.dateDifference(startDate, endDate);
        EmployeeType employeeType = employeeList.getEmployee(employeeId).getEmployeeType();

        if(employeeList.getEmployee(employeeId).getLeaves().get(new Category(employeeType, leaveType)) < daysCount){
            return false;
        }
        int currentAvailableDays = employeeList.getEmployee(employeeId).getLeaves().get(new Category(employeeType, leaveType));
        employeeList.getEmployee(employeeId).getLeaves().put(new Category(employeeType, leaveType), currentAvailableDays - daysCount);
        return true;
    }
}
