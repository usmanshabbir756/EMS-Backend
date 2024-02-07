package com.usman.ems.mapper;

import com.usman.ems.dto.EmployeeDto;
import com.usman.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployee(Employee employee){
        return new EmployeeDto(employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail());
    }

    public static Employee mapToEmployeeDto(EmployeeDto employeeDto){
        return new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail());
    }
}
