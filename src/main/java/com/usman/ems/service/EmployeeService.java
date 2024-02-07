package com.usman.ems.service;

import com.usman.ems.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto getEmployeeById(Long emplyeeId);
}
