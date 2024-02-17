package com.utfpr.store.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "funcionario")
@NamedQuery(
        name = "Employees.byDependents",
        query = "SELECT e FROM Employee e WHERE e.dependent = ?1"
        )
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_departamento", nullable = false)
    private Department department;

    @Column(name = "nome", length = 100)
    private String name;

    @Column(name = "dependentes")
    private Integer dependent;

    @Column(name = "salario", precision = 10, scale = 2)
    private BigDecimal wage;

    @Column(name = "cargo", length = 50)
    private String position;

}
