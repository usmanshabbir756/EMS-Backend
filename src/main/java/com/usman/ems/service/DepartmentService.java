package com.usman.ems.service;

import com.usman.ems.dto.DepartmentDto;

public interface DepartmentService {
     DepartmentDto createDeparmrnt(DepartmentDto departmentDto);

     DepartmentDto getDeparmentById(Long departmentId);
}
