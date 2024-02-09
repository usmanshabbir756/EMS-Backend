package com.usman.ems.mapper;

import com.usman.ems.dto.DepartmentDto;
import com.usman.ems.entity.Department;

public class DepartmentMapper {

    //convert department dto into department jpa
    public static DepartmentDto departmentDtoMapper(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    //convert department jpa into department dto
    public static Department departmentMapper(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
                );
    }

}
