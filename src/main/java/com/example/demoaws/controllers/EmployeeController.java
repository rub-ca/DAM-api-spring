package com.example.demoaws.controllers;

import com.example.demoaws.models.Employee;
import com.example.demoaws.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        Employee em = employeeService.getEmployeeById(id);
        // El empleado sera nulo cuando no se encuentre
        // Devolvemos un empleado con todos los campos en null
        return (em != null) ? em : new Employee();
    }

    @PostMapping(consumes = {"application/json"})
    public Employee saveEmployee(@RequestBody Employee emp) {
        return employeeService.saveEmployee(emp);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        return employeeService.updateEmployee(id, emp);
    }
}
