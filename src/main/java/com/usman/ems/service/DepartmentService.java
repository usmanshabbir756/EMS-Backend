package com.usman.ems.service;

import com.usman.ems.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
     DepartmentDto createDeparmrnt(DepartmentDto departmentDto);

     DepartmentDto getDeparmentById(Long departmentId);

     List<DepartmentDto> getAllDepartment();

     DepartmentDto updateDepartment(Long departmentId,DepartmentDto departmentDto);

     String deleteDepartment(Long departmentId);
}
