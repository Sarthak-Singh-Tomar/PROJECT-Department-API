package com.sartech.springboot.project.service;

import com.sartech.springboot.project.entity.Department;
import com.sartech.springboot.project.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updatedepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
