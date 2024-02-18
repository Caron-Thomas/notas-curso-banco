package com.utfpr.store.service;

import com.utfpr.store.entity.Employee;
import com.utfpr.store.repository.EmployeeRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    public List<Employee> findByDependents(Integer dependents) {
        return repository.findByDependents(dependents);
    }

    public List<Employee> findWithPartialName(String name) {
        return repository.findWithPartialName(name);
    }
}
