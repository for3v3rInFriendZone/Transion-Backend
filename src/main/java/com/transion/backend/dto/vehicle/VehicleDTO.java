package com.transion.backend.dto.vehicle;

public class VehicleDTO {

	private Long id;
	private String plate;
	private String description;
	private Integer seats;
	private String name;
	private String chassis;
	private BrandDTO brand;
	private VehicleTypeDTO type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public VehicleTypeDTO getType() {
		return type;
	}

	public void setType(VehicleTypeDTO type) {
		this.type = type;
	}

}
