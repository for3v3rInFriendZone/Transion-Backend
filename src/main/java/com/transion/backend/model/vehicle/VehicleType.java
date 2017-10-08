package com.transion.backend.model.vehicle;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLETYPE")
public class VehicleType implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CAPACITY_FROM")
	private Double capacityFrom;
	
	@Column(name = "CAPACITY_TO")
	private Double capacityTo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCapacityFrom() {
		return capacityFrom;
	}

	public void setCapacityFrom(Double capacityFrom) {
		this.capacityFrom = capacityFrom;
	}

	public Double getCapacityTo() {
		return capacityTo;
	}

	public void setCapacityTo(Double capacityTo) {
		this.capacityTo = capacityTo;
	}
}
