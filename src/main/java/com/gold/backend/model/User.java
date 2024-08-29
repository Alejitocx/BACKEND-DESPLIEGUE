package com.gold.backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @Column(name = "EMAIL_USER", nullable = false, unique = true)
    private String emailUser;

    @Column(name = "PASSWORD_USER", nullable = false, unique = true)
    private String passwordUser;

    @ManyToOne
    @JoinColumn(name = "EMPLOYE_CODE", referencedColumnName = "EMPLOYE_CODE", nullable = false)
    private Empleado employee;

    // Getters and Setters

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Empleado getEmployee() {
        return employee;
    }

    public void setEmployee(Empleado employee) {
        this.employee = employee;
    }

	public User(String emailUser, String passwordUser, Empleado employee) {
		super();
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.employee = employee;
	}

	public User() {
		super();
	}

}
