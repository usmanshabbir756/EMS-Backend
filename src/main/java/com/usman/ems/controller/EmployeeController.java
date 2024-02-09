package com.usman.ems.controller;

import com.usman.ems.dto.EmployeeDto;
import com.usman.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build to add Employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    //Get Employee By id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Get All Employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Update Employee Data
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEpmloyee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEpmloyee);
        return ResponseEntity.ok(employeeDto);
    }

    //Delete Employee by Id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
