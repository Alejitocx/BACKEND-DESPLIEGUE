package com.gold.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "employee")
public class Empleado {

    @Id
    @Column(name = "EMPLOYE_CODE", nullable = false, length = 30 , unique = true)
    private String employeCode;

    // Getters and Setters

    public String getEmployeCode() {
        return employeCode;
    }

    public void setEmployeCode(String employeCode) {
        this.employeCode = employeCode;
    }
}
