package com.usman.ems.service;

import com.usman.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto getEmployeeById(Long emplyeeId);
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
    public void deleteEmployeeById(Long employeeId);
}
