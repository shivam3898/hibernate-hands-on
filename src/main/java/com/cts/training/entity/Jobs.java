package com.cts.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Jobs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "job_id")
	private Integer id;
	
	@Column(name = "job_title", nullable = false)
	private String jobTitle;
	
	@Column(name = "min_salary")
	private Double minSalary;
	
	@Column(name = "max_salary")
	private Double maxSalary;
	
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	private Set<Employees> employees = new HashSet<>();
	
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	private Set<JobHistory> jobHistories = new HashSet<>();
}
