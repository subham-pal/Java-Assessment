package com.subham.assessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    EmployeeType employeeType;
    LeaveType leaveType;
}
