package com.example.demoaws.controllers;

import com.example.demoaws.models.Detailed;
import com.example.demoaws.models.Employee;
import com.example.demoaws.services.DepartmentService;
import com.example.demoaws.services.EmployeeService;
import com.example.demoaws.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detailed")
public class DetailedController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    @GetMapping("/{id}")
    public Detailed getDetailedById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) return new Detailed();
        return new Detailed(employee, departmentService.getDepartmentById(employee.getDepartment_id()),
                jobService.getJobById(employee.getJob_id()));
    }
}
