package com.cts.training.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Integer id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	@Column(name = "hire_date")
	private LocalDate hireDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "job_id", nullable = false)
	private Jobs job;
	
	private Double salary;
	
	@Column(name = "commission_pct")
	private Double commissionPct;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "manager_id")
	private Employees manager;
	
	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private Set<Employees> employees = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "department_id")
	private Departments department;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<JobHistory> jobHistory = new HashSet<>();
	
	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private Set<Departments> departments = new HashSet<>();
}
