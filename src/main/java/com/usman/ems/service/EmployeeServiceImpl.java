package com.usman.ems.service;

import com.usman.ems.EmsBackendApplication;
import com.usman.ems.dto.EmployeeDto;
import com.usman.ems.entity.Employee;
import com.usman.ems.mapper.EmployeeMapper;
import com.usman.ems.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }
}
