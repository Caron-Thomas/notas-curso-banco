package com.utfpr.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "departamento")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod", nullable = false)
    private Long id;

    @Column(name = "nome", length = 50)
    private String DepartmentName;
}
