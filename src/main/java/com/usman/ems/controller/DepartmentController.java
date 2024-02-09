package com.usman.ems.controller;

import com.usman.ems.dto.DepartmentDto;
import com.usman.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

   // http://localhost:8080/api/department
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.createDeparmrnt(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/department/1
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDeparmentById(@PathVariable("id") Long deparmentId ){
        DepartmentDto departmentDto=departmentService.getDeparmentById(deparmentId);
        return ResponseEntity.ok(departmentDto);
    }

    // http://localhost:8080/api/department
    @GetMapping
    public List<DepartmentDto> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    // http://localhost:8080/api/department/1
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.updateDepartment(departmentId,departmentDto);
        return ResponseEntity.ok(saveDepartment);
    }


    // http://localhost:8080/api/department/1
    @DeleteMapping("{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
    return departmentService.deleteDepartment(departmentId);
    }
}
