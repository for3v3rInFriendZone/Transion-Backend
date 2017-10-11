package com.transion.backend.dto.vehicle;

public class VehicleTypeDTO {

	private Long id;
	private String name;
	private Double capacityFrom;
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
