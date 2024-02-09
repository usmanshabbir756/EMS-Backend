package com.usman.ems.controller;

import com.usman.ems.dto.DepartmentDto;
import com.usman.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.createDeparmrnt(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDeparmentById(@PathVariable("id") Long deparmentId ){
        DepartmentDto departmentDto=departmentService.getDeparmentById(deparmentId);
        return ResponseEntity.ok(departmentDto);
    }

}
