package com.example.demoaws.services;

import com.example.demoaws.models.Department;
import com.example.demoaws.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        if (id == null) return null;
        return departmentRepository.findById(id).orElse(null);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Long id, Department department) {
        Department departmentToUpdate = departmentRepository.findById(id).orElse(null);
        if (departmentToUpdate == null) return null;
        departmentToUpdate.setDepartment_name(department.getDepartment_name());
        departmentToUpdate.setManager_id(department.getManager_id());
        departmentToUpdate.setLocation_id(department.getLocation_id());
        return departmentRepository.save(departmentToUpdate);
    }
}
