package com.example.demoaws.services;

import com.example.demoaws.models.Employee;
import com.example.demoaws.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee emp) {
        Employee empToUpdate = employeeRepository.findById(id).orElse(null);
        if (empToUpdate == null) return null;
        empToUpdate.setFirst_name(emp.getFirst_name());
        empToUpdate.setLast_name(emp.getLast_name());
        empToUpdate.setEmail(emp.getEmail());
        empToUpdate.setPhone_number(emp.getPhone_number());
        empToUpdate.setHire_date(emp.getHire_date());
        empToUpdate.setJob_id(emp.getJob_id());
        empToUpdate.setSalary(emp.getSalary());
        empToUpdate.setCommission_pct(emp.getCommission_pct());
        empToUpdate.setManager_id(emp.getManager_id());
        empToUpdate.setDepartment_id(emp.getDepartment_id());
        return employeeRepository.save(empToUpdate);
    }

}
