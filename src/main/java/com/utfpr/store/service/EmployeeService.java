package com.utfpr.store.service;

import com.utfpr.store.entity.Employee;
import com.utfpr.store.repository.EmployeeRepository;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Employee findByNameAndDependents(String name, Integer dependents) {
        return repository.findByNameAndDependent(name, dependents);
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return repository.findByDepartmentId(departmentId);
    }

    public Employee findFirstByWage() {
        return repository.findFirstByOrderByWageDesc();
    }

    public List<Employee> findThreeByWage() {
        return repository.findFirst3ByOrderByWageDesc();
    }

    public List<Employee> findWithNoDependentsAsc() {
        return repository.findWithNoDependentsAsc();
    }

    public List<Employee> findEmployeesByWageAfter(BigDecimal wage) {
        return repository.findEmployeesByWageAfter(wage);
    }

    public List<Employee> findEmployeesByWageBiggerThan(BigDecimal wage) {
        return repository.findEmployeesByWageBiggerThan(wage);
    }

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

    public Employee findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
