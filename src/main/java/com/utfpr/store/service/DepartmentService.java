package com.utfpr.store.service;

import com.utfpr.store.entity.Department;
import com.utfpr.store.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department findOldestDepartment() {
        return repository.findFirstBy();
    }


    public List<Department> listAllDepartments() {
        return repository.findAll();
    }

    public Department createDepartment(String name){

        Department d = new Department();
        d.setDepartmentName(name);

        return repository.save(d);
    }
}
