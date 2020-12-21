package com.cts.training.entity;

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
public class Locations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id")
	private Integer id;
	
	@Column(name = "street_address")
	private String streetAddress;
	
	@Column(name = "postal_code")
	private Integer postalCode;
	
	@Column(nullable = false)
	private String city;
	
	@Column(name = "state_province")
	private String stateProvince;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "country_id", nullable = false)
	private Countries country;
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private Set<Departments> departments = new HashSet<>();
	
	
}
