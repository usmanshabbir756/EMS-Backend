package com.usman.ems.service;

import com.usman.ems.EmsBackendApplication;
import com.usman.ems.dto.EmployeeDto;
import com.usman.ems.entity.Employee;
import com.usman.ems.exception.ResponceNotFoundException;
import com.usman.ems.mapper.EmployeeMapper;
import com.usman.ems.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        ()->new ResponceNotFoundException("Employee does not exist of id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
