package com.usman.ems.service;

import com.usman.ems.dto.DepartmentDto;
import com.usman.ems.entity.Department;
import com.usman.ems.exception.ResponseNotFoundException;
import com.usman.ems.mapper.DepartmentMapper;
import com.usman.ems.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDeparmrnt(DepartmentDto departmentDto) {
        Department department= DepartmentMapper.departmentMapper(departmentDto);
        Department saveDepartment =departmentRepository.save(department);
        return DepartmentMapper.departmentDtoMapper(saveDepartment);
    }

    @Override
    public DepartmentDto getDeparmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResponseNotFoundException("Department not Found of id : " + departmentId)
        );

        return DepartmentMapper.departmentDtoMapper(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments=departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper::departmentDtoMapper).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResponseNotFoundException("Department not Found of id : " + departmentId)
        );
        Department updatedDepartment=DepartmentMapper.departmentMapper(departmentDto);
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        Department saveDepartment=departmentRepository.save(department);
        return DepartmentMapper.departmentDtoMapper(saveDepartment);
    }

    @Override
    public String deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResponseNotFoundException("Department not Found of id : " + departmentId)
        );
        System.out.println(departmentId);
        departmentRepository.deleteById(departmentId);
        return "Deleted successfully";
    }
}
