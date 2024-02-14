package com.utfpr.store.service;

import com.utfpr.store.entity.Employee;
import com.utfpr.store.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Employee createEmployee(String name, Integer dependent, BigDecimal wage, String position, Long departmentId) {

        Employee e = new Employee();
        e.getDepartment().setId(departmentId);
        e.setName(name);
        e.setDependent(dependent);
        e.setWage(wage);
        e.setPosition(position);

        return repository.save(e);
    }

    public List<Employee> listAllEmployees() {
        return repository.findAll();
    }
}
