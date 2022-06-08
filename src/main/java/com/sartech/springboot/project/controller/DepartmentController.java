package com.sartech.springboot.project.controller;

import com.sartech.springboot.project.entity.Department;
import com.sartech.springboot.project.error.DepartmentNotFoundException;
import com.sartech.springboot.project.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Building RESTApi for Department which performs following funcitons:
 * 1) Save Department - POST
 * 2) Get Department - GET
 * 3) Delete Department - DELETE
 * 4) Update Department - PUT
 * 5) Get Department by ID - GET
 * 6) Get Department by Name - GET
 */


@RestController
public class DepartmentController {

    // This property based injection / class level injection / field injection.
//    @Autowired
//    private DepartmentService service;



//    This is Constructor based injection
//    private DepartmentService service;
//    public DepartmentController(DepartmentService service) {
//        this.service = service;
//    }

//    This is Setter Injection
    private DepartmentService service;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    public DepartmentService getService() {
        return service;
    }
    @Autowired
    public void setService(DepartmentService service) {
        this.service = service;
    }



//    API to Create Department
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return service.saveDepartment(department);
    }

//    API to Get Department
    @GetMapping("/departments")
    public List<Department> fetchDepartment() {
        LOGGER.info("Inside fetchDepartment of DepartmentController");
        return service.fetchDepartment();
    }

//    API to Get Department by ID
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return service.fetchDepartmentById(departmentId);
    }

//    API to Delete Department
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        service.deleteDepartmentById(departmentId);
        return "Department with ID: " + departmentId + " +has been deleted successfully.";
    }

//    API to update Department
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return service.updatedepartment(departmentId, department);
    }

//    API to Get Department By Name
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return service.fetchDepartmentByName(departmentName);
    }

}
