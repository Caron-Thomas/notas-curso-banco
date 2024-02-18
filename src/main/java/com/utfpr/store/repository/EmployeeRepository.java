package com.utfpr.store.repository;

import com.utfpr.store.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByNameAndDependent(String name, Integer dependent);

    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1")
    List<Employee> findByDepartmentId(Long departmentId );

    Employee findFirstByOrderByWageDesc();

    List<Employee> findFirst3ByOrderByWageDesc();

    @Query("SELECT e FROM Employee e WHERE e.dependent = 0 OR e.dependent IS NULL ORDER BY e.name ASC")
    List<Employee> findWithNoDependentsAsc();

    @Query("SELECT e FROM Employee e WHERE e.wage > ?1 ")
    List<Employee> findEmployeesByWageAfter(BigDecimal wage);

    @Query(value = "SELECT * FROM funcionario f WHERE f.salario > ?1", nativeQuery = true)
    List<Employee> findEmployeesByWageBiggerThan(BigDecimal wage);

    @Query(name = "Employees.byDependents")
    List<Employee> findByDependents(Integer dependents);

    @Query(name = "Employees.withName")
    List<Employee> findWithPartialName(String name);
}
