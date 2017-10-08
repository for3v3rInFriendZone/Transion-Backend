package com.transion.backend.model.vehicle;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PLATE", nullable = false, unique = true)
	private String plate;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "SEATS")
	private Integer seats;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CHASSIS", nullable = false, unique = true)
	private String chassis;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BRAND_ID")
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID")
	private VehicleType type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FUEL_ID")
	private Fuel fuel;

}
