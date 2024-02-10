package com.usman.ems.service;

import com.usman.ems.dto.EmployeeDto;
import com.usman.ems.entity.Department;
import com.usman.ems.entity.Employee;
import com.usman.ems.exception.ResponseNotFoundException;
import com.usman.ems.mapper.EmployeeMapper;
import com.usman.ems.repository.DepartmentRepository;
import com.usman.ems.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    @Override
    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Department department=departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(
                ()-> new ResponseNotFoundException("Department not exit id: " + employeeDto.getDepartmentId())
        );
        employee.setDepartment(department);
        Employee saveEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        ()->new ResponseNotFoundException("Employee does not exist of id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee= employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResponseNotFoundException("Employee Not Found with id : " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Department department=departmentRepository.findById(updatedEmployee.getDepartmentId())
                .orElseThrow(
                        ()-> new ResponseNotFoundException("Department not exit id: " + updatedEmployee.getDepartmentId())
                );
        employee.setDepartment(department);
        Employee employee1=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee1);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResponseNotFoundException("Employee Not Found with id : " + employeeId));
        employeeRepository.deleteById(employeeId);
    }


}
